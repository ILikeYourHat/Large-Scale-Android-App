package pl.softwarealchemy.lsaa.core.di

import android.app.Application
import org.koin.core.module.Module

internal class MultiModuleApplication : Application() {

    internal val modules = mutableListOf<Module>()

    override fun onCreate() {
        super.onCreate()
        initializeKoin(this, modules)
    }
}
