package pl.softwarealchemy.lsaa.app.screen

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick

internal class TaskListScreenObject private constructor(
    private val composeTestRule: AndroidComposeTestRule<*, *>
) {

    fun clickSettings() = apply {
        composeTestRule.onNode(
            hasContentDescription("Settings")
        ).performClick()
    }

    companion object {
        fun AndroidComposeTestRule<*, *>.onTaskListScreen() = TaskListScreenObject(this)
    }
}
