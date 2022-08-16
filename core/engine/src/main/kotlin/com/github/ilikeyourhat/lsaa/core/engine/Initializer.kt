package com.github.ilikeyourhat.lsaa.core.engine

@Suppress("unused")
public class Initializer : ModuleInitializer(
    {
        single { TopActivityProvider() }
    }
)
