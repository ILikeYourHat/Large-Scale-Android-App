package pl.softwarealchemy.lsaa.feature.settings.home

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import pl.softwarealchemy.lsaa.feature.settings.InternalSettingsNavigator

internal class SettingsViewModelTest {

    private val navigator = mockk<InternalSettingsNavigator>(relaxed = true)
    private val viewModel = SettingsViewModel(navigator)

    @Test
    fun `should go to licenses screen after licenses clicked`() {
        viewModel.onLicensesClicked()

        verify { navigator.goToLicenses() }
    }
}