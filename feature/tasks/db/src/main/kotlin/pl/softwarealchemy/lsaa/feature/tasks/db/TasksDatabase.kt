package pl.softwarealchemy.lsaa.feature.tasks.db

public interface TasksDatabase {
    public suspend fun getAllTasks(): List<Task>
}
