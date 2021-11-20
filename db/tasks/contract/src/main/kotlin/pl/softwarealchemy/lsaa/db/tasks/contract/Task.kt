package pl.softwarealchemy.lsaa.db.tasks.contract

import java.time.ZonedDateTime

data class Task(
    val id: String,
    val content: String,
    val creationTime: ZonedDateTime,
)
