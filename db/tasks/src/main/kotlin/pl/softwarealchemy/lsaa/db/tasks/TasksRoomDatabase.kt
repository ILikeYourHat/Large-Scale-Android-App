package pl.softwarealchemy.lsaa.db.tasks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import pl.softwarealchemy.lsaa.db.tasks.contract.Task
import pl.softwarealchemy.lsaa.db.tasks.contract.TasksDatabase
import java.time.ZonedDateTime

class TasksRoomDatabase : TasksDatabase {

    override suspend fun getAllTasks(): List<Task> = coroutineScope {
        val tasks = async(Dispatchers.IO) {
            delay(5000)
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
