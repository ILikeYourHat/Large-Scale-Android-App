package com.github.ilikeyourhat.lsaa.feature.tasks.list

import com.github.ilikeyourhat.lsaa.feature.tasks.db.Task

internal sealed class TaskListUiState {

    object Loading : TaskListUiState()

    data class Ready(
        val tasks: List<Task>
    ) : TaskListUiState()
}
