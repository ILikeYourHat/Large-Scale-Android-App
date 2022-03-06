package pl.softwarealchemy.lsaa.core.engine

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import org.koin.core.module.Module

abstract class ModuleInitializer(
    private val module: Module
) : Initializer<Unit> {

    override fun create(context: Context) {
        if (context is MultiModuleApplication) {
            Log.i("ModuleInitializer", "Registering ${javaClass.canonicalName}")
            context.modules.add(module)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
