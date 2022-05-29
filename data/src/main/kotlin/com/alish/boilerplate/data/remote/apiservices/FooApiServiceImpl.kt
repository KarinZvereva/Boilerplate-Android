package com.alish.boilerplate.data.remote.apiservices

import com.alish.boilerplate.data.remote.dtos.foo.FooDto
import kotlinx.coroutines.delay
import javax.inject.Inject

class FooApiServiceImpl @Inject constructor() : FooApiService {

    override suspend fun fetchFoo(): FooDto {
        delay(3000)
        return FooDto(1, "baz")
    }
}