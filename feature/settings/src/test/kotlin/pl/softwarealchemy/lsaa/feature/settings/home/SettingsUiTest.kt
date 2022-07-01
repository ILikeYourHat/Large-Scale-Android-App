package pl.softwarealchemy.lsaa.feature.settings.home

import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

internal class SettingsUiTest {

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0
    )

    @Test
    fun normal() {
        paparazzi.snapshot { SettingsUi_Normal() }
    }
}
