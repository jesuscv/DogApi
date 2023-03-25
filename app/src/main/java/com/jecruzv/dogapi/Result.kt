package com.jecruzv.dogapi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result (
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)