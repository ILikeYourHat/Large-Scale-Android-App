package pl.softwarealchemy.lsaa.feature.tasks

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.engine.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.tasks.db.TasksDbKoinModule
import pl.softwarealchemy.lsaa.feature.tasks.list.TaskListViewModel

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    TasksDbKoinModule(),
    module {
        viewModel {
            TaskListViewModel(
                settingsNavigator = get(),
                tasksDao = get()
            )
        }
    }
)
