package com.github.ilikeyourhat.lsaa.core.engine

import com.github.ilikeyourhat.lsaa.core.engine.contract.ITopActivityProvider
import com.github.ilikeyourhat.lsaa.core.engine.contract.ModuleInitializer

@Suppress("unused")
public class Initializer : ModuleInitializer(
    {
        single<ITopActivityProvider> { TopActivityProvider() }
    }
)
