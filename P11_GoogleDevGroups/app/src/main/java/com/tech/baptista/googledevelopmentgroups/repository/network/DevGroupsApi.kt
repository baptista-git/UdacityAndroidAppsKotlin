package com.tech.baptista.googledevelopmentgroups.repository.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

interface DevGroupsApiService {
    @GET("gdg-directory.json")
    suspend fun getChapters(): DevGroupResponse
}
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object DevGroupsApi {
    val retrofitService : DevGroupsApiService by lazy { retrofit.create(DevGroupsApiService::class.java) }
}