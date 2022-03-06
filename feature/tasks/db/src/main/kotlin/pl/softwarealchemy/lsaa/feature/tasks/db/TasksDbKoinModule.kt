package pl.softwarealchemy.lsaa.feature.tasks.db

import org.koin.dsl.module
import pl.softwarealchemy.lsaa.feature.tasks.db.internal.TasksRoomDatabase

object TasksDbKoinModule {
    operator fun invoke() = module {
        single<TasksDatabase> { TasksRoomDatabase() }
    }
}
