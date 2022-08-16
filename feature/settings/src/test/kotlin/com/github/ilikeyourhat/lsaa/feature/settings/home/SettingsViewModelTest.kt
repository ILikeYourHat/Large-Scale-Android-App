package com.github.ilikeyourhat.lsaa.feature.settings.home

import com.github.ilikeyourhat.lsaa.feature.settings.InternalSettingsNavigator
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class SettingsViewModelTest {

    private val navigator = mockk<InternalSettingsNavigator>(relaxed = true)
    private val viewModel = SettingsViewModel(navigator)

    @Test
    fun `should go to licenses screen after licenses clicked`() {
        viewModel.onLicensesClicked()

        verify { navigator.goToLicenses() }
    }
}
