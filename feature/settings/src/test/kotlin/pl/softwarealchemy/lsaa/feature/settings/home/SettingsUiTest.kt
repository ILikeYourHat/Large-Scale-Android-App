package pl.softwarealchemy.lsaa.feature.settings.home

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

internal class SettingsUiTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun normal() {
        paparazzi.snapshot { SettingsUi_Normal() }
    }
}
