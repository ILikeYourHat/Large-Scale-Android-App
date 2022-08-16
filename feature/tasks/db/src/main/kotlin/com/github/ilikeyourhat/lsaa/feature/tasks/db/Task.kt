package com.github.ilikeyourhat.lsaa.feature.tasks.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "task")
public data class Task(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "creationTime")
    val creationTime: ZonedDateTime,
)
