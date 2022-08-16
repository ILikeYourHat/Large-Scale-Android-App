package com.github.ilikeyourhat.lsaa.feature.settings.licenses.ui

import app.cash.paparazzi.Paparazzi
import com.github.ilikeyourhat.lsaa.feature.settings.licenses.LicensesUi_Normal
import org.junit.Rule
import org.junit.Test

internal class LicensesUiTest {

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0
    )

    @Test
    fun normal() {
        paparazzi.snapshot { LicensesUi_Normal() }
    }
}
