package pl.softwarealchemy.lsaa.feature.settings.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SettingsActivity : ComponentActivity() {

    private val vm: SettingsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsUi(uiListener = vm)
        }
    }
}
