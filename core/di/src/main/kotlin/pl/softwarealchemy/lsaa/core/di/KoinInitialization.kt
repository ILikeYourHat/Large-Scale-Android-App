package pl.softwarealchemy.lsaa.core.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initializeKoin(application: Application, modules: List<Module>) {
    startKoin {
        androidContext(application)
        module {
            single { TopActivityProvider() }
        }
        modules(modules)
    }
}
