package pl.softwarealchemy.lsaa.feature.one.core

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.di.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.one.contract.GreetingProvider

@Suppress("unused")
internal class FeatureOneInitializer: ModuleInitializer(
    module {
        single(named("polish")) { GreetingProvider { "Dzień dobry" } }
    }
)
