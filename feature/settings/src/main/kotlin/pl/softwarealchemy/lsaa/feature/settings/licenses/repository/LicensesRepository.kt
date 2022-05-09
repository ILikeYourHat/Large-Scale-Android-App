package pl.softwarealchemy.lsaa.feature.settings.licenses.repository

import android.content.Context
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext

internal class LicensesRepository(
    private val context: Context
) {
    fun getLicenses(): List<LibraryLicense> {
        return getRawLicenses().libraries.map { library ->
            LibraryLicense(
                libraryName = library.name,
                licenseName = library.licenses.firstOrNull()?.name.orEmpty()
            )
        }
    }

    private fun getRawLicenses(): Libs {
        return Libs.Builder()
            .withContext(context)
            .build()
    }
}
