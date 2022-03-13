package pl.softwarealchemy.lsaa.feature.settings.licenses.repository

import android.content.Context
import com.mikepenz.aboutlibraries.Libs
import java.io.BufferedReader

internal class LicensesRepository(
    private val context: Context
) {
    fun getLicenses(): List<LibraryLicense> {
        val resId = context.resources.getIdentifier("licenses", "raw", context.packageName)
        val json = context.resources.openRawResource(resId)
            .bufferedReader()
            .use(BufferedReader::readText)

        val libs = Libs.Builder()
            .withJson(json)
            .build()

        return libs.libraries.map {
            LibraryLicense(
                libraryName = it.name,
                licenseName = it.licenses.firstOrNull()?.name ?: ""
            )
        }
    }
}
