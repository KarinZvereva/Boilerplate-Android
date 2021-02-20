package com.alis.boilerplate.servicelocator

import com.alis.boilerplate.data.PreferencesHelper
import com.alis.boilerplate.data.network.RetrofitClient
import com.alis.boilerplate.data.repositories.Repository
import com.alis.boilerplate.ui.fragments.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

val repositoryModule = module {
    factory { Repository(get()) }
}

val localModule = module {
    single { PreferencesHelper(androidContext()) }
}

val networkModule = module {
    single { RetrofitClient().provideAPI() }
}