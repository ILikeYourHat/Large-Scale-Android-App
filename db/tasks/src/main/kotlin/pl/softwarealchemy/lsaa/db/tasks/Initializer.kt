package pl.softwarealchemy.lsaa.db.tasks

import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.di.ModuleInitializer
import pl.softwarealchemy.lsaa.db.tasks.contract.TasksDatabase

@Suppress("unused")
class Initializer: ModuleInitializer(
    module {
        single<TasksDatabase> { TasksRoomDatabase() }
    }
)
