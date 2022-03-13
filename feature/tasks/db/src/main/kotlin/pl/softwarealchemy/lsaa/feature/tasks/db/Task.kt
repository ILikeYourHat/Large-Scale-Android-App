package pl.softwarealchemy.lsaa.feature.tasks.db

import java.time.ZonedDateTime

public data class Task(
    val id: String,
    val content: String,
    val creationTime: ZonedDateTime,
)
