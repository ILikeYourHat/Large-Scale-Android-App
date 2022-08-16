package com.github.ilikeyourhat.lsaa.app.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.AndroidComposeTestRule

internal class LicensesScreenObject private constructor(
    private val composeTestRule: AndroidComposeTestRule<*, *>
) {
    fun assertHasLicense(licenseName: String) = apply {
        composeTestRule.onNode(
            hasText(licenseName)
        ).assertIsDisplayed()
    }

    companion object {
        fun AndroidComposeTestRule<*, *>.onLicensesScreen() = LicensesScreenObject(this)
    }
}
