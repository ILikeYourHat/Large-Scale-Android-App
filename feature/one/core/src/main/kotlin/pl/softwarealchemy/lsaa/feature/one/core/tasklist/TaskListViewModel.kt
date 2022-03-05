package pl.softwarealchemy.lsaa.feature.one.core.tasklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.softwarealchemy.lsaa.db.tasks.contract.TasksDatabase
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator

class TaskListViewModel(
    private val settingsNavigator: SettingsNavigator,
    private val tasksDatabase: TasksDatabase
) : ViewModel() {

    private val _screenState = MutableLiveData<TaskListUiState>(TaskListUiState.Loading)

    val screenState: LiveData<TaskListUiState> = _screenState

    fun onCreate() {
        refreshTasks()
    }

    fun showSettingsScreen() {
        settingsNavigator.goToSettings()
    }

    private fun refreshTasks() {
        viewModelScope.launch {
            val tasks = tasksDatabase.getAllTasks()
            _screenState.postValue(TaskListUiState.Ready(tasks))
        }
    }
}
