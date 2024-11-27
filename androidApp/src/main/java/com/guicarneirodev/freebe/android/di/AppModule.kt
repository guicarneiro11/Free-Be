package com.guicarneirodev.freebe.android.di

import com.guicarneirodev.freebe.android.presentation.screens.registration.DriverRegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::DriverRegistrationViewModel)
}