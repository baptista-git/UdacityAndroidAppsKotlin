package com.tech.baptista.devbyteviewer.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideosDatabase : RoomDatabase() {
    abstract val videoDao: VideoDao

    companion object {
        private lateinit var INSTANCE: VideosDatabase

        fun getInstance(context: Context): VideosDatabase {
            synchronized(VideosDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        VideosDatabase::class.java,
                        "videos")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}



