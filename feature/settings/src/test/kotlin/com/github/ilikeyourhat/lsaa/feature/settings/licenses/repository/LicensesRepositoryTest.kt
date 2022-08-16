package com.github.ilikeyourhat.lsaa.feature.settings.licenses.repository

import androidx.test.core.app.ApplicationProvider
import assertk.all
import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.isEmpty
import assertk.assertions.isGreaterThan
import assertk.assertions.size
import io.mockk.every
import io.mockk.slot
import io.mockk.spyk
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class LicensesRepositoryTest {

    private val context = spyk(ApplicationProvider.getApplicationContext())
    private val repository = LicensesRepository(context)

    @Test
    fun `should parse empty licenses`() {
        setLicensesContent("empty")

        val licenses = repository.getLicenses()

        assertThat(licenses).isEmpty()
    }

    @Test
    fun `should parse example licenses`() {
        setLicensesContent("example")

        val licenses = repository.getLicenses()

        assertThat(licenses).all {
            size().isGreaterThan(10)
            contains(
                LibraryLicense(
                    libraryName = "koin-core",
                    licenseName = "Apache License 2.0"
                )
            )
        }
    }

    @Test
    fun `should parse invalid licenses`() {
        setLicensesContent("invalid")

        val licenses = repository.getLicenses()

        assertThat(licenses).isEmpty()
    }

    private fun setLicensesContent(testCase: String) {
        val fakeResourceId = 1234
        val slot = slot<String>()

        every {
            context.resources.getIdentifier(capture(slot), "raw", any())
        } returns fakeResourceId

        every {
            context.resources.openRawResource(fakeResourceId)
        } answers {
            context.assets.open("LicensesRepositoryTest/${slot.captured}_$testCase.json")
        }
    }
}
