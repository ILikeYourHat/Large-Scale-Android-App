package com.github.ilikeyourhat.lsaa.feature.settings.home

import androidx.lifecycle.ViewModel
import com.github.ilikeyourhat.lsaa.feature.settings.InternalSettingsNavigator

internal class SettingsViewModel(
    private val settingsNavigator: InternalSettingsNavigator
) : ViewModel(), SettingsListener {

    override fun onLicensesClicked() {
        settingsNavigator.goToLicenses()
    }
}
