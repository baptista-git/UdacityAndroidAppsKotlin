package com.tech.baptista.trackmysleepquality.screens.sleepquality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tech.baptista.trackmysleepquality.database.SleepDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel for SleepQualityFragment.
 *
 * @param sleepNightKey The key of the current night we are working on.
 */
class SleepQualityViewModel(private val sleepNightKey: Long = 0L, val database: SleepDatabaseDao) :
    ViewModel() {

    private val viewModelJob = Job()
    private val uiScope =  CoroutineScope(Dispatchers.Main + viewModelJob)


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    /**
     * Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
     * When true immediately navigate back to the [SleepTrackerFragment]
     */
    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()
    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker
    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

     /**
     * Sets the sleep quality and updates the database.
     * Then navigates back to the SleepTrackerFragment.
     */
    fun onSetSleepQuality(quality: Int) {
         uiScope.launch {
             withContext(Dispatchers.IO) {
                 val tonight = database.get(sleepNightKey) ?: return@withContext
                 tonight.sleepQuality = quality
                 database.update(tonight)
             }
             // Setting this state variable to true will alert the observer and trigger navigation.
             _navigateToSleepTracker.value = true

         }
    }
}
