package com.github.ilikeyourhat.lsaa.app.test

import com.github.ilikeyourhat.lsaa.app.screen.LicensesScreenObject.Companion.onLicensesScreen
import com.github.ilikeyourhat.lsaa.app.screen.SettingsScreenObject.Companion.onSettingsScreen
import com.github.ilikeyourhat.lsaa.app.screen.TaskListScreenObject.Companion.onTaskListScreen
import com.github.ilikeyourhat.lsaa.app.util.ScreenName
import com.github.ilikeyourhat.lsaa.app.util.launchScreenRule
import com.github.ilikeyourhat.lsaa.app.util.runTest
import org.junit.Rule
import org.junit.Test

internal class AppTest {

    @get:Rule
    val rule = launchScreenRule(ScreenName.TASK_LIST)

    @Test
    fun testLicensesScreen() = rule.runTest {
        onTaskListScreen()
            .clickSettings()
        onSettingsScreen()
            .openLicenses()
        onLicensesScreen()
            .assertHasLicense("AboutLibraries Library")
            .assertHasLicense("Android AppCompat Library")
    }
}
