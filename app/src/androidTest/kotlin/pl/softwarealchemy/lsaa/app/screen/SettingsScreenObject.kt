package pl.softwarealchemy.lsaa.app.screen

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick

internal class SettingsScreenObject private constructor(
    private val composeTestRule: AndroidComposeTestRule<*, *>
) {
    fun openLicenses() = apply {
        composeTestRule.onNode(
            hasText("Licenses")
        ).performClick()
    }

    companion object {
        fun AndroidComposeTestRule<*, *>.onSettingsScreen() = SettingsScreenObject(this)
    }
}
