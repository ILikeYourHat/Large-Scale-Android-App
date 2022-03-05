package pl.softwarealchemy.lsaa.feature.one.core

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.di.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.one.core.tasklist.TaskListViewModel

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    module {
        viewModel {
            TaskListViewModel(
                settingsNavigator = get(),
                tasksDatabase = get()
            )
        }
    }
)
