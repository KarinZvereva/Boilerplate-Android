package com.alish.boilerplate.presentation.models

import com.alish.boilerplate.common.base.IBaseDiffModel
import com.alish.boilerplate.domain.models.Foo

data class FooUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel

fun Foo.toFooUI() = FooUI(id, bar)