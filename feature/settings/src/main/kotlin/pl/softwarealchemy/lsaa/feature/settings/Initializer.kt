package pl.softwarealchemy.lsaa.feature.settings

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.engine.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator
import pl.softwarealchemy.lsaa.feature.settings.home.SettingsViewModel

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    module {
        viewModel {
            SettingsViewModel(
                settingsNavigator = get()
            )
        }

        single {
            InternalSettingsNavigator(
                topActivityProvider = get()
            )
        } bind SettingsNavigator::class
    }
)
