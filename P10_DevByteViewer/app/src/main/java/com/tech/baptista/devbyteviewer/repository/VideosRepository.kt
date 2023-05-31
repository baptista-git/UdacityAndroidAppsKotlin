package com.tech.baptista.devbyteviewer.repository

import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.tech.baptista.devbyteviewer.domain.Video
import com.tech.baptista.devbyteviewer.repository.database.VideosDatabase
import com.tech.baptista.devbyteviewer.repository.database.asDomainModel
import com.tech.baptista.devbyteviewer.repository.network.DevbyteApi
import com.tech.baptista.devbyteviewer.repository.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideosRepository(private val database: VideosDatabase) {

    /**
     * A playlist of videos that can be shown on the screen.
     */
    val videos: LiveData<List<Video>> =
        database.videoDao.getVideos().map {
            it.asDomainModel()
        }

    /**
     * Refresh the videos stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     * To actually load the videos for use, observe [videos]
     */
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = DevbyteApi.retrofitService.getPlaylist()
            database.videoDao.insertAll(*playlist.asDatabaseModel())
        }
    }
}