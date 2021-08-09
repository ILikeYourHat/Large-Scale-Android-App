package pl.softwarealchemy.lsaa.feature.one.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.android.ext.android.inject
import pl.softwarealchemy.lsaa.feature.two.contract.FeatureTwoRouter

internal class FeatureOneActivity : ComponentActivity() {

    private val featureTwoRouter by inject<FeatureTwoRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatureOneScreen { onButtonClicked() }
        }
    }

    private fun onButtonClicked() {
        val intent = featureTwoRouter.toFeatureTwoActivity()
        startActivity(intent)
    }
}
