package com.github.ilikeyourhat.lsaa.feature.settings.licenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.ilikeyourhat.lsaa.feature.settings.licenses.repository.LicensesRepository
import org.koin.android.ext.android.get

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
