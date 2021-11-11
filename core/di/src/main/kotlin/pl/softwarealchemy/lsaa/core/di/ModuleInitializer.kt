package pl.softwarealchemy.lsaa.core.di

import android.content.Context
import androidx.startup.Initializer
import org.koin.core.module.Module

abstract class ModuleInitializer(
    private val module: Module
) : Initializer<Unit> {

    override fun create(context: Context) {
        if (context is MultiModuleApplication) {
            context.modules.add(module)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
