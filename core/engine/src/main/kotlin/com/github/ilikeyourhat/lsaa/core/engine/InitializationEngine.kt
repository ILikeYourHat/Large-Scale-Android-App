package com.github.ilikeyourhat.lsaa.core.engine

import android.app.Application
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.github.ilikeyourhat.lsaa.util.android.getApplicationInfoCompat
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.isSubclassOf

internal class InitializationEngine {

    fun start(application: MultiModuleApplication) {
        val modules = extractModules(application.metaData)

        startKoin {
            androidContext(application)
            modules(modules)
        }
    }

    private val Application.metaData: Bundle
        get() = packageManager
            .getApplicationInfoCompat(packageName, PackageManager.GET_META_DATA)
            .metaData

    private fun extractModules(metaData: Bundle): List<Module> {
        return metaData.keySet()
            .mapNotNull { it to metaData.getString(it) }
            .filter { (_, value) -> value == METADATA_MODULE_INITIALIZER_TAG }
            .mapNotNull { tryToCreateInstance(it.first) }
            .map { module(moduleDeclaration = it.moduleDeclaration) }
    }

    private fun tryToCreateInstance(className: String): ModuleInitializer? {
        return findClass(className)
            ?.createInitializerInstance()
            ?.also { Log.i(TAG, "$className successfully initialized") }
    }

    private fun findClass(className: String): KClass<out Any>? {
        return try {
            Class.forName(className).kotlin
        } catch (ex: ClassNotFoundException) {
            Log.e(TAG, "$className not found in classpath, aborting", ex)
            null
        }
    }

    private fun KClass<out Any>.createInitializerInstance(): ModuleInitializer? {
        if (isSubclassOf(ModuleInitializer::class)) {
            try {
                return createInstance() as ModuleInitializer
            } catch (ex: IllegalArgumentException) {
                Log.e(TAG, "$qualifiedName doesn't have no-args constructor, aborting", ex)
            }
        } else {
            Log.e(TAG, "$qualifiedName not a subclass of ModuleInitializer, aborting")
        }
        return null
    }

    companion object {
        private const val TAG = "InitializerEngine"
        private const val METADATA_MODULE_INITIALIZER_TAG = "ModuleInitializer"
    }
}
