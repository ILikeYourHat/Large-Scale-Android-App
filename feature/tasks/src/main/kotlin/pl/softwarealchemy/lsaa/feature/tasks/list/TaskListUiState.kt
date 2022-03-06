package pl.softwarealchemy.lsaa.feature.tasks.list

import pl.softwarealchemy.lsaa.feature.tasks.db.Task

sealed class TaskListUiState {

    object Loading : TaskListUiState()

    data class Ready(
        val tasks: List<Task>
    ) : TaskListUiState()
}
