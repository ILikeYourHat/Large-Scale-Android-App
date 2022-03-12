package pl.softwarealchemy.lsaa.feature.settings

import android.content.Intent
import pl.softwarealchemy.lsaa.core.engine.TopActivityProvider
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator
import pl.softwarealchemy.lsaa.feature.settings.home.SettingsActivity
import pl.softwarealchemy.lsaa.feature.settings.licenses.LicensesActivity

internal class InternalSettingsNavigator(
    private val topActivityProvider: TopActivityProvider
) : SettingsNavigator {

    override fun goToSettings() {
        topActivityProvider.onTopActivity { activity ->
            val intent = Intent(activity, SettingsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    fun goToLicenses() {
        topActivityProvider.onTopActivity { activity ->
            val intent = Intent(activity, LicensesActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
