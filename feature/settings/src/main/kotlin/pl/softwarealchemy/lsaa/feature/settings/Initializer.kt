package pl.softwarealchemy.lsaa.feature.settings

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import pl.softwarealchemy.lsaa.core.engine.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator
import pl.softwarealchemy.lsaa.feature.settings.home.SettingsViewModel
import pl.softwarealchemy.lsaa.feature.settings.licenses.repository.LicensesRepository

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    {
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

        single {
            LicensesRepository(
                context = androidContext()
            )
        }
    }
)
