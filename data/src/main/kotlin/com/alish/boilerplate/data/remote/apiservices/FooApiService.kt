package com.alish.boilerplate.data.remote.apiservices

import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import retrofit2.http.GET

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): FooDto
}