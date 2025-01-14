package com.alish.boilerplate.di

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.data.remote.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideTokenErrorListener() = MutableLiveData<String>()

    @Singleton
    @Provides
    fun provideAuthenticatorApiService(
        authenticatorClient: NetworkClient.AuthenticatorClient
    ) = authenticatorClient.provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideFooApiService(
        networkClient: NetworkClient
    ) = networkClient.provideFooApiService()
}