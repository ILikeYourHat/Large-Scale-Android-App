package com.github.ilikeyourhat.lsaa.feature.tasks.list

import com.github.ilikeyourhat.lsaa.feature.tasks.db.Task

internal interface TaskListListener {
    fun onShowSettingsClicked()
    fun onTaskClicked(task: Task)
    fun onAddTaskClicked()
}
