package pl.softwarealchemy.lsaa.feature.tasks.db

interface TasksDatabase {
    suspend fun getAllTasks(): List<Task>
}
