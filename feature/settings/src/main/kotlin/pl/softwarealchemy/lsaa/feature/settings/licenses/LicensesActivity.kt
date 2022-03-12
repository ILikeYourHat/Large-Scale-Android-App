package pl.softwarealchemy.lsaa.feature.settings.licenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LicensesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LicensesUi() }
    }
}
