package com.jecruzv.dogapi

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("character") fun charactersAsync(): Deferred<Response<Characters>>
}