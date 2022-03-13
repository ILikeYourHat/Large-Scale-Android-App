package pl.softwarealchemy.lsaa.feature.tasks.db

import org.koin.core.module.Module
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.feature.tasks.db.internal.TasksRoomDatabase

public object TasksDbKoinModule {
    public operator fun invoke(): Module = module {
        single<TasksDatabase> { TasksRoomDatabase() }
    }
}
