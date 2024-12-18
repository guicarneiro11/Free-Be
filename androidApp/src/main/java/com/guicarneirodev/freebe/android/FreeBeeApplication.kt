package com.guicarneirodev.freebe.android

import android.app.Application
import com.guicarneirodev.freebe.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FreeBeeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FreeBeeApplication)
            modules(appModule)
        }
    }
}