package pl.softwarealchemy.lsaa.feature.tasks.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class TaskListActivity : ComponentActivity() {

    private val viewModel: TaskListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.screenState.observe(this) { uiState ->
            setContent {
                TaskListUi(
                    uiState = uiState,
                    onItemClick = { viewModel.showSettingsScreen() },
                    onAddClick = { viewModel.addTask() }
                )
            }
        }
        viewModel.onCreate()
    }
}
