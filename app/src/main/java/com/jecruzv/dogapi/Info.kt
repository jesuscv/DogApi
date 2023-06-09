package com.jecruzv.dogapi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Info (
    val count: Long,
    val pages: Long,
    val next: String,
    val prev: Any? = null
)