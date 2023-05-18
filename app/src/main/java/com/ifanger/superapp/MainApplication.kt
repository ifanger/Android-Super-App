package com.ifanger.superapp

import android.app.Application
import com.ifanger.superapp.di.DependencyInjection
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    private val dependencyInjection = DependencyInjection()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(dependencyInjection.modules)
        }
    }
}