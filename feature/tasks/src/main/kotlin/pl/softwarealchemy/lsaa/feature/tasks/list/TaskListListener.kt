package pl.softwarealchemy.lsaa.feature.tasks.list

import pl.softwarealchemy.lsaa.feature.tasks.db.Task

internal interface TaskListListener {
    fun onShowSettingsClicked()
    fun onTaskClicked(task: Task)
    fun onAddTaskClicked()
}
