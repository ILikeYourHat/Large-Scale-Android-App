package pl.softwarealchemy.lsaa.feature.one.core.tasklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.softwarealchemy.lsaa.db.tasks.contract.TasksDatabase

class TaskListViewModel(
    private val tasksDatabase: TasksDatabase
): ViewModel() {

    private val _screenState = MutableLiveData<TaskListUiState>(TaskListUiState.Loading)

    val screenState : LiveData<TaskListUiState> = _screenState

    fun onCreate() {
        refreshTasks()
    }

    private fun refreshTasks() {
        viewModelScope.launch {
            val tasks = tasksDatabase.getAllTasks()
            _screenState.value = TaskListUiState.Ready(tasks)
        }
    }
}
