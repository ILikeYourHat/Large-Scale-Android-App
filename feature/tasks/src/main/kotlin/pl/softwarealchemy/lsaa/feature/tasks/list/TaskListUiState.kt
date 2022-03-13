package pl.softwarealchemy.lsaa.feature.tasks.list

import pl.softwarealchemy.lsaa.feature.tasks.db.Task

internal sealed class TaskListUiState {

    object Loading : TaskListUiState()

    data class Ready(
        val tasks: List<Task>
    ) : TaskListUiState()
}
