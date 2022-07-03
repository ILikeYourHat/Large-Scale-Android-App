package pl.softwarealchemy.lsaa.feature.tasks.db

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

internal class ZonedDateTypeConverterTest {

    private val converter = ZonedDateTypeConverter()

    @ParameterizedTest
    @NullSource
    @ValueSource(
        strings = [
            "2011-12-03T10:15:30+01:00[Europe/Paris]",
            "2023-01-23T16:57:01+01:00[Europe/Warsaw]"
        ]
    )
    fun `test converter`(dateString: String?) {
        val zonedDateTime = converter.toDate(dateString)
        val parsedDateString = converter.toDateString(zonedDateTime)

        assertThat(parsedDateString).isEqualTo(dateString)
    }

    @Test
    fun `test invalid input`() {
        val zonedDateTime = converter.toDate("trololo")

        assertThat(zonedDateTime).isNull()
    }
}
