package pl.softwarealchemy.lsaa.feature.two.core

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.di.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.one.contract.GreetingProvider
import pl.softwarealchemy.lsaa.feature.two.contract.FeatureTwoRouter

@Suppress("unused")
internal class FeatureTwoInitializer : ModuleInitializer(
    module {
        single<FeatureTwoRouter> { FeatureTwoRouterImpl(get()) }
        single(named("german")) { GreetingProvider { "Guten tag" } }
    }
)
