package pl.softwarealchemy.lsaa.feature.tasks.db

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

public object TasksDbKoinModule {

    public operator fun invoke(): Module = module {

        single {
            Room.databaseBuilder(
                androidContext(),
                TasksDatabase::class.java,
                "tasks-database"
            ).build()
        }

        single { get<TasksDatabase>().taskDao() }
    }
}
