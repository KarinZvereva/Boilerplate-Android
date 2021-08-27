package com.alish.boilerplate.data.network.apiservices

import com.alish.boilerplate.models.Foo
import retrofit2.http.GET

interface FooApiService {

    @GET("/api/foo")
    suspend fun fetchFoo(): Foo
}