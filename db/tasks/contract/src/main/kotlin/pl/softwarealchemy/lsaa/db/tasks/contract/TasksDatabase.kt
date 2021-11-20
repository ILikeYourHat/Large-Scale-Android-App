package pl.softwarealchemy.lsaa.db.tasks.contract

interface TasksDatabase {
    suspend fun getAllTasks(): List<Task>
}
