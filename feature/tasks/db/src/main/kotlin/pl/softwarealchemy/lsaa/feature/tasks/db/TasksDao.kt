package pl.softwarealchemy.lsaa.feature.tasks.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
public interface TasksDao {

    @Query("SELECT * FROM task")
    public suspend fun getAll(): List<Task>

    @Insert
    public suspend fun insertAll(vararg tasks: Task)
}
