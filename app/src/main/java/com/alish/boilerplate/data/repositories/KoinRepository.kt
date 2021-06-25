package com.alish.boilerplate.data.repositories

import com.alish.boilerplate.data.db.room.daos.FooDao
import com.alish.boilerplate.data.network.retrofit.apiservices.FooApiService

class KoinRepository(
    private val fooApiService: FooApiService,
    private val fooDao: FooDao
) {
    // …
}