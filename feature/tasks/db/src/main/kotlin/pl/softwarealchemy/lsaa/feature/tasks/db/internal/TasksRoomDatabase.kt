package pl.softwarealchemy.lsaa.feature.tasks.db.internal

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import pl.softwarealchemy.lsaa.feature.tasks.db.Task
import pl.softwarealchemy.lsaa.feature.tasks.db.TasksDatabase
import java.time.ZonedDateTime

internal class TasksRoomDatabase : TasksDatabase {

    override suspend fun getAllTasks(): List<Task> = coroutineScope {
        val tasks = async(Dispatchers.IO) {
            delay(timeMillis = 5000)
            listOf(
                Task(
                    id = "1234",
                    content = "Zrobić pranie",
                    creationTime = ZonedDateTime.now()
                ),
                Task(
                    id = "1235",
                    content = "Uratować świat",
                    creationTime = ZonedDateTime.now().minusDays(1)
                )
            )
        }
        tasks.await()
    }
}
