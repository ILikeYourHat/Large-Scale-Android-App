package pl.softwarealchemy.lsaa.feature.tasks.db

import java.time.ZonedDateTime

data class Task(
    val id: String,
    val content: String,
    val creationTime: ZonedDateTime,
)
