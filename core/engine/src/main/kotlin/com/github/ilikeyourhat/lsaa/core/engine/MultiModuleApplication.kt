package com.github.ilikeyourhat.lsaa.core.engine

import android.app.Application
import org.koin.android.ext.android.get

internal class MultiModuleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InitializationEngine().start(this)

        get<TopActivityProvider>().attach(this)
    }
}
