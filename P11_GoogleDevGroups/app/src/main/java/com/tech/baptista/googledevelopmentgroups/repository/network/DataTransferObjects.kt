package com.tech.baptista.googledevelopmentgroups.repository.network

import android.os.Parcelable
import com.squareup.moshi.Json

data class DevGroupChapter(
    @Json(name = "chapter_name") val name: String,
    @Json(name = "cityarea") val city: String,
    val country: String,
    val region: String,
    val website: String,
    val geo: LatLong
)

data class LatLong(
    val lat: Double,
    @Json(name = "lng")
    val long: Double
)

data class DevGroupResponse(
    @Json(name = "filters_") val filters: Filter,
    @Json(name = "data") val chapters: List<DevGroupChapter>
)

data class Filter(
    @Json(name = "region") val regions: List<String>
)