package com.tech.baptista.devbyteviewer.screens.devbyte

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.tech.baptista.devbyteviewer.repository.VideosRepository
import com.tech.baptista.devbyteviewer.repository.database.VideosDatabase
import kotlinx.coroutines.launch


/**
 * DevByteViewModel designed to store and manage UI-related data in a lifecycle conscious way. This
 * allows data to survive configuration changes such as screen rotations. In addition, background
 * work such as fetching network results can continue through configuration changes and deliver
 * results after the new Fragment or Activity is available.
 *
 * @param application The application that this viewmodel is attached to, it's safe to hold a
 * reference to applications across rotation since Application is never recreated during actiivty
 * or fragment lifecycle events.
 */
class DevByteViewModel(application: Application) : AndroidViewModel(application) {

    // The internal MutableLiveData /external immutable LiveData String that stores the response of the most recent request
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    /**
     * A playlist of videos that can be shown on the screen. This is private to avoid exposing a
     * way to set this value to observers.
     */
//    private val _playlist = MutableLiveData<List<Video>>()
//    val playlist: LiveData<List<Video>>
//        get() = _playlist



    private val database = VideosDatabase.getInstance(application)
    private val videosRepository = VideosRepository(database)

    val playlist = videosRepository.videos

    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        //refreshDataFromNetwork()

        viewModelScope.launch {
            videosRepository.refreshVideos()
        }
    }

    /**
     * Refresh data from network and pass it via LiveData. Use a coroutine launch to get to
     * background thread.
     */
//    private fun refreshDataFromNetwork() = viewModelScope.launch {
//        try {
//            val playlist = DevbyteApi.retrofitService.getPlaylist()
//            _response.value = "List of ${playlist.videos.size} videos received"
//            _playlist.postValue(playlist.asDomainModel())
//        } catch (networkError: IOException) {
//            _response.value = "Failure: ${networkError.message}"
//        }
//    }


    /**
     * Factory for constructing DevByteViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DevByteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DevByteViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}