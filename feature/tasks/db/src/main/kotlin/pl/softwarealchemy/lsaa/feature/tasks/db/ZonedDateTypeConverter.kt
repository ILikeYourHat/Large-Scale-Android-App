package pl.softwarealchemy.lsaa.feature.tasks.db

import androidx.room.TypeConverter
import java.time.ZonedDateTime
import java.time.format.DateTimeParseException

internal class ZonedDateTypeConverter {

    @TypeConverter
    fun toDate(dateString: String?): ZonedDateTime? {
        return try {
            dateString?.let { ZonedDateTime.parse(it) }
        } catch (e: DateTimeParseException) {
            null
        }
    }

    @TypeConverter
    fun toDateString(date: ZonedDateTime?): String? {
        return date?.toString()
    }
}
