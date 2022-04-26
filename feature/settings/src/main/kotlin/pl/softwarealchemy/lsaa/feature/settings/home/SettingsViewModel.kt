package pl.softwarealchemy.lsaa.feature.settings.home

import androidx.lifecycle.ViewModel
import pl.softwarealchemy.lsaa.feature.settings.InternalSettingsNavigator

internal class SettingsViewModel(
    private val settingsNavigator: InternalSettingsNavigator
) : ViewModel(), SettingsListener {

    override fun onLicensesClicked() {
        settingsNavigator.goToLicenses()
    }
}
