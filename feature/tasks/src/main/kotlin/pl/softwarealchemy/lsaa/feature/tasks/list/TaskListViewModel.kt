package pl.softwarealchemy.lsaa.feature.tasks.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.softwarealchemy.lsaa.feature.settings.contract.SettingsNavigator
import pl.softwarealchemy.lsaa.feature.tasks.db.Task
import pl.softwarealchemy.lsaa.feature.tasks.db.TasksDao
import java.time.ZonedDateTime
import java.util.UUID

internal class TaskListViewModel(
    private val settingsNavigator: SettingsNavigator,
    private val tasksDao: TasksDao
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
            val tasks = tasksDao.getAll()
            _screenState.postValue(TaskListUiState.Ready(tasks))
        }
    }

    fun addTask() {
        viewModelScope.launch {
            val task = Task(
                id = UUID.randomUUID().toString(),
                content = "Uratować świat",
                creationTime = ZonedDateTime.now()
            )
            tasksDao.insertAll(task)
            refreshTasks()
        }
    }
}
