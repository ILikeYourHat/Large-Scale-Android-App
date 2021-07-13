package pl.softwarealchemy.lsaa.feature.two.core

import android.content.Context
import android.content.Intent
import pl.softwarealchemy.lsaa.feature.two.contract.FeatureTwoRouter

internal class FeatureTwoRouterImpl(
    private val context: Context
): FeatureTwoRouter {
    override fun toFeatureTwoActivity(): Intent {
        return Intent(context, FeatureTwoActivity::class.java)
    }
}
