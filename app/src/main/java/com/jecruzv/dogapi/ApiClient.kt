package com.jecruzv.dogapi

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {
    @GET("breeds/list/all") fun getBreedsAsync(): Deferred<Response<List<Breeds>>>
}