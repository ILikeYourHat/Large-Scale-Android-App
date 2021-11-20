package pl.softwarealchemy.lsaa.feature.one.core.tasklist

import pl.softwarealchemy.lsaa.db.tasks.contract.Task

sealed class TaskListUiState {

    object Loading : TaskListUiState()

    data class Ready(
        val tasks: List<Task>
    ) : TaskListUiState()
}
