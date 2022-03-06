package pl.softwarealchemy.lsaa.feature.settings

import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.engine.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    module {
        single<SettingsNavigator> {
            SettingsNavigatorImpl(
                topActivityProvider = get()
            )
        }
    }
)
