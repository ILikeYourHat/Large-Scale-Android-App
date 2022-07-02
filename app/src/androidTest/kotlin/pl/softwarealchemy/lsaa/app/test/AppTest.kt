package pl.softwarealchemy.lsaa.app.test

import org.junit.Rule
import org.junit.Test
import pl.softwarealchemy.lsaa.app.screen.LicensesScreenObject.Companion.onLicensesScreen
import pl.softwarealchemy.lsaa.app.screen.SettingsScreenObject.Companion.onSettingsScreen
import pl.softwarealchemy.lsaa.app.screen.TaskListScreenObject.Companion.onTaskListScreen
import pl.softwarealchemy.lsaa.app.util.ScreenName
import pl.softwarealchemy.lsaa.app.util.launchScreenRule
import pl.softwarealchemy.lsaa.app.util.runTest

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