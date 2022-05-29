package com.alish.boilerplate.presentation.models

import com.alish.boilerplate.domain.models.Foo

data class FooUI(
    val id: Long,
    val bar: String
)

fun Foo.toUI() = FooUI(id, bar)