package pl.softwarealchemy.lsaa.core.engine

import org.koin.core.module.Module

public open class ModuleInitializer(
    public vararg val modules: Module
)
