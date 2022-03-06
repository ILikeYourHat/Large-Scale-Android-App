package pl.softwarealchemy.lsaa.feature.tasks.db

import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.engine.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.tasks.db.internal.TasksRoomDatabase

@Suppress("unused")
class Initializer : ModuleInitializer(
    module {
        single<TasksDatabase> { TasksRoomDatabase() }
    }
)
