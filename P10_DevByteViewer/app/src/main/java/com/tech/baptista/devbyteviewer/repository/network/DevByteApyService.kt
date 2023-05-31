package com.tech.baptista.devbyteviewer.repository.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://devbytes.udacity.com/"



/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A retrofit service to fetch a devbyte playlist.
 */
interface DevByteApyService {
    @GET("devbytes.json")
    suspend fun getPlaylist(): NetworkVideoContainer
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object DevbyteApi {
    // Configure retrofit to parse JSON
    val retrofitService:DevByteApyService by lazy { retrofit.create(DevByteApyService::class.java)}
}