package com.github.ilikeyourhat.lsaa.feature.tasks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(
    ZonedDateTypeConverter::class,
)
@Database(
    version = 1,
    entities = [
        Task::class,
    ]
)
internal abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TasksDao
}
