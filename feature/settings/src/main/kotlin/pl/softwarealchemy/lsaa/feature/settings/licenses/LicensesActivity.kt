package pl.softwarealchemy.lsaa.feature.settings.licenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.android.ext.android.get
import pl.softwarealchemy.lsaa.feature.settings.licenses.repository.LicensesRepository

internal class LicensesActivity : ComponentActivity() {

    private val repository: LicensesRepository = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LicensesUi(
                licenses = repository.getLicenses()
            )
        }
    }
}
