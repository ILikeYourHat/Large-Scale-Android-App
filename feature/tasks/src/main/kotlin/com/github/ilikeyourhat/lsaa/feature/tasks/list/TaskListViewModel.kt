package com.github.ilikeyourhat.lsaa.feature.tasks.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ilikeyourhat.lsaa.feature.settings.contract.SettingsNavigator
import com.github.ilikeyourhat.lsaa.feature.tasks.db.Task
import com.github.ilikeyourhat.lsaa.feature.tasks.db.TasksDao
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.util.UUID

internal class TaskListViewModel(
    private val settingsNavigator: SettingsNavigator,
    private val tasksDao: TasksDao
) : ViewModel(), TaskListListener {

    private val _screenState = MutableLiveData<TaskListUiState>(TaskListUiState.Loading)

    val screenState: LiveData<TaskListUiState> = _screenState

    fun onCreate() {
        viewModelScope.launch {
            refreshTasks()
        }
    }

    override fun onShowSettingsClicked() {
        settingsNavigator.goToSettings()
    }

    override fun onAddTaskClicked() {
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

    override fun onTaskClicked(task: Task) {
        // noop
    }

    private suspend fun refreshTasks() {
        val tasks = tasksDao.getAll()
        _screenState.postValue(TaskListUiState.Ready(tasks))
    }
}
