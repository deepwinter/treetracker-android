package org.greenstand.android.TreeTracker.di

import android.content.Context
import android.location.LocationManager
import org.greenstand.android.TreeTracker.managers.PlanterManager
import org.greenstand.android.TreeTracker.managers.TreeManager
import org.greenstand.android.TreeTracker.managers.UserLocationManager
import org.greenstand.android.TreeTracker.managers.UserManager
import org.greenstand.android.TreeTracker.usecases.CreateTreeUseCase
import org.greenstand.android.TreeTracker.viewmodels.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { LoginViewModel(get(), get()) }

    viewModel { SignupViewModel() }

    viewModel { TermsPolicyViewModel(get(), get()) }

    viewModel { TreeHeightViewModel(get(), get()) }

    viewModel { DataViewModel(get(), get(), get(), get()) }

    single { TreeManager(get(), get()) }

    single { UserManager(get(), get()) }

    single { PlanterManager(get(), get()) }

    single { androidContext().getSharedPreferences("org.greenstand.android", Context.MODE_PRIVATE) }

    single { androidContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager }

    single { UserLocationManager(get(), get()) }

    factory { CreateTreeUseCase(get(), get(), get()) }
}