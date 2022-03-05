package pl.softwarealchemy.lsaa.feature.settings

import android.content.Intent
import pl.softwarealchemy.lsaa.core.di.TopActivityProvider
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator
import pl.softwarealchemy.lsaa.feature.settings.home.SettingsActivity

class SettingsNavigatorImpl(
    private val topActivityProvider: TopActivityProvider
) : SettingsNavigator {

    override fun goToSettings() {
        topActivityProvider.onTopActivity { activity ->
            val intent = Intent(activity, SettingsActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
