package pl.softwarealchemy.lsaa.app.util

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule

internal fun launchScreenRule(screenName: ScreenName): AndroidComposeTestRule<ActivityScenarioRule<ComponentActivity>, ComponentActivity> {
    @Suppress("UNCHECKED_CAST")
    return createAndroidComposeRule(Class.forName(screenName.className) as Class<ComponentActivity>)
}

internal fun AndroidComposeTestRule<*, *>.runTest(block: AndroidComposeTestRule<*, *>.() -> Unit) {
    this.block()
}