package com.github.ilikeyourhat.lsaa.feature.settings

import com.github.ilikeyourhat.lsaa.core.engine.ModuleInitializer
import com.github.ilikeyourhat.lsaa.feature.settings.contract.SettingsNavigator
import com.github.ilikeyourhat.lsaa.feature.settings.home.SettingsViewModel
import com.github.ilikeyourhat.lsaa.feature.settings.licenses.repository.LicensesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind

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
