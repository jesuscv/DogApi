package com.jecruzv.dogapi
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breeds ( val status : String, val message: Message)