package com.github.ilikeyourhat.lsaa.feature.settings

import android.content.Intent
import com.github.ilikeyourhat.lsaa.core.engine.contract.ITopActivityProvider
import com.github.ilikeyourhat.lsaa.feature.settings.contract.SettingsNavigator
import com.github.ilikeyourhat.lsaa.feature.settings.home.SettingsActivity
import com.github.ilikeyourhat.lsaa.feature.settings.licenses.LicensesActivity

internal class InternalSettingsNavigator(
    private val topActivityProvider: ITopActivityProvider
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
