package com.github.ilikeyourhat.lsaa.feature.tasks

import com.github.ilikeyourhat.lsaa.core.engine.contract.ModuleInitializer
import com.github.ilikeyourhat.lsaa.feature.tasks.db.TasksDbKoinModule
import com.github.ilikeyourhat.lsaa.feature.tasks.list.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    {
        includes(TasksDbKoinModule())

        viewModel {
            TaskListViewModel(
                settingsNavigator = get(),
                tasksDao = get()
            )
        }
    }
)
