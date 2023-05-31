package com.tech.baptista.googledevelopmentgroups.screens.overview

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.baptista.googledevelopmentgroups.repository.network.DevGroupChapter
import com.tech.baptista.googledevelopmentgroups.repository.network.DevGroupResponse
import com.tech.baptista.googledevelopmentgroups.repository.network.DevGroupsApi
import com.tech.baptista.googledevelopmentgroups.repository.network.LatLong
import kotlinx.coroutines.launch
import java.io.IOException

class OverviewViewModel: ViewModel() {
    private lateinit var repository: DevGroupsRepository
    private var filter = FilterHolder()

    private val _devGroupList = MutableLiveData<List<DevGroupChapter>>()
    val devGroupList: LiveData<List<DevGroupChapter>>
        get() = _devGroupList

    private val _regionList = MutableLiveData<List<String>>()
    val regionList: LiveData<List<String>>
        get() = _regionList


    init {
        viewModelScope.launch {
            repository = DevGroupsRepository(DevGroupsApi.retrofitService.getChapters())
            onQueryChanged()
        }
    }

    private fun onQueryChanged() {
            viewModelScope.launch {
            try {
                // this will run on a thread managed by Retrofit
                _devGroupList.value = repository.getChaptersForFilter(filter.currentValue)
                repository.getFilters().let {
                    // only update the filters list if it's changed since the last time
                    if (it != _regionList.value) {
                        _regionList.value = it
                    }
                }
            } catch (e: IOException) {
                _devGroupList.value = defaultList
            }
        }
    }

    fun onLocationUpdated(location: Location) {
        viewModelScope.launch {
            repository.onLocationChanged(location)
            onQueryChanged()
        }
    }

    fun onFilterChanged(filter: String, isChecked: Boolean) {
        if (this.filter.update(filter, isChecked)) {
            onQueryChanged()
        }
    }
    private class FilterHolder {
        var currentValue: String? = null
            private set

        fun update(changedFilter: String, isChecked: Boolean): Boolean {
            if (isChecked) {
                currentValue = changedFilter
                return true
            } else if (currentValue == changedFilter) {
                currentValue = null
                return true
            }
            return false
        }
    }


    val defaultList = listOf(
            DevGroupChapter(
                "Google Developer Group Lisboa",
                "Lisbon",
                "Portugal",
                "Europe",
                "https://www.meetup.com/gdglisbon",
                LatLong(38.72000122,-9.140000343)
            ),
            DevGroupChapter(
                "GDG Porto",
                "Porto",
                "Portugal",
                "Europe",
                "https://www.meetup.com/GDG-Porto",
                LatLong(41.15000153,-8.619999886)
            ),
            DevGroupChapter(
                "GDG Madeira",
                "Funchal",
                "Portugal",
                "Europe",
                "https://www.meetup.com/gdgmadeira",
                LatLong(32.65000153,-16.89999962)
            ),
            DevGroupChapter(
                "GDG Wrocław",
                "Wroclaw",
                "Poland",
                "Europe",
                "https://www.meetup.com/GDG-Wroclaw",
                LatLong(51.11000061, 17.03000069)
            )
        )
}