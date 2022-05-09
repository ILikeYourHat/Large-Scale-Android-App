package pl.softwarealchemy.lsaa.feature.settings.licenses.repository

import android.content.Context
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext

internal class LicensesRepository(
    private val context: Context
) {
    fun getLicenses(): List<LibraryLicense> {
        val libs = Libs.Builder()
            .withContext(context)
            .build()

        return libs.libraries.map {
            LibraryLicense(
                libraryName = it.name,
                licenseName = it.licenses.firstOrNull()?.name ?: ""
            )
        }
    }
}
