package com.alish.boilerplate.data.repositories.core

import android.util.Log
import com.alish.boilerplate.data.BuildConfig
import com.alish.boilerplate.domain.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

const val REPOSITORY_TAG = "Repository"

internal fun <T> doRequest(request: suspend () -> T) = flow<Either<String, T>> {
    request().also { data ->
        if (BuildConfig.DEBUG) Log.d(REPOSITORY_TAG, "${this.javaClass.simpleName}: $data")
        emit(Either.Right(value = data))
    }
}.flowOn(Dispatchers.IO).catch { exception ->
    if (BuildConfig.DEBUG) Log.e(REPOSITORY_TAG, this.javaClass.simpleName, exception)
    emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
}