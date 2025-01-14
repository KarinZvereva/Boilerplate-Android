package com.alish.boilerplate.presentation.models

import com.alish.boilerplate.domain.models.Foo
import com.alish.boilerplate.presentation.base.IBaseDiffModel

data class FooUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel<Long>

fun Foo.toUI() = FooUI(id, bar)