package pl.softwarealchemy.lsaa.feature.settings.licenses.ui

import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test
import pl.softwarealchemy.lsaa.feature.settings.licenses.LicensesUi_Normal

internal class LicensesUiTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5
    )

    @Test
    fun normal() {
        paparazzi.snapshot { LicensesUi_Normal() }
    }
}
