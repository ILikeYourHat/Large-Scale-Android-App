package pl.softwarealchemy.lsaa.core.engine

import org.koin.dsl.module

@Suppress("unused")
public class Initializer : ModuleInitializer(
    module {
        single { TopActivityProvider() }
    }
)
