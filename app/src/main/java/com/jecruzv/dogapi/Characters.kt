package com.jecruzv.dogapi
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Characters (val info: Info, val results: List<Result>)