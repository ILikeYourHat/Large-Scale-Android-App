package pl.softwarealchemy.lsaa.core.engine

import android.app.Application
import org.koin.android.ext.android.get
import org.koin.core.module.Module

internal class MultiModuleApplication : Application() {

    internal val modules = mutableListOf<Module>()

    override fun onCreate() {
        super.onCreate()
        initializeKoin(this, modules)

        get<TopActivityProvider>().attach(this)
    }
}
