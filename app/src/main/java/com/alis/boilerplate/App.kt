package com.alis.boilerplate

import android.app.Application
import com.alis.boilerplate.servicelocator.localModule
import com.alis.boilerplate.servicelocator.networkModule
import com.alis.boilerplate.servicelocator.repositoriesModule
import com.alis.boilerplate.servicelocator.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelsModule, repositoriesModule, localModule, networkModule)
        }
    }
}