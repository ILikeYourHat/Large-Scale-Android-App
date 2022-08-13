package pl.softwarealchemy.lsaa.feature.tasks.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.softwarealchemy.lsaa.feature.tasks.R
import pl.softwarealchemy.lsaa.feature.tasks.db.Task
import java.time.ZonedDateTime

@Composable
internal fun TaskListUi(
    uiState: TaskListUiState,
    uiListener: TaskListListener
) {
    MaterialTheme {
        Scaffold(
            topBar = {
                Toolbar(uiListener)
            },
            content = { paddingValues ->
                Content(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    uiState = uiState,
                    uiListener = uiListener
                )
            },
            floatingActionButton = {
                Fab(uiListener)
            }
        )
    }
}

@Composable
private fun Toolbar(
    uiListener: TaskListListener
) {
    TopAppBar(
        title = { Text("My tasks") },
        elevation = 2.dp,
        actions = {
            IconButton(
                onClick = { uiListener.onShowSettingsClicked() }
            ) {
                Icon(Icons.Filled.Settings, stringResource(R.string.tsk_settings_button))
            }
        }
    )
}

@Composable
private fun Content(
    uiState: TaskListUiState,
    uiListener: TaskListListener,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        TaskListUiState.Loading -> {
            Loading(
                modifier = modifier
            )
        }
        is TaskListUiState.Ready -> {
            if (uiState.tasks.isEmpty()) {
                EmptyContent(
                    modifier = modifier
                )
            } else {
                ActualContent(
                    modifier = modifier,
                    uiState = uiState,
                    uiListener = uiListener
                )
            }
        }
    }
}

@Composable
private fun Fab(
    uiListener: TaskListListener
) {
    FloatingActionButton(
        onClick = { uiListener.onAddTaskClicked() }
    ) {
        Icon(Icons.Filled.Add, "")
    }
}

@Composable
private fun EmptyContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Nothing here"
        )
    }
}

@Composable
private fun ActualContent(
    uiState: TaskListUiState.Ready,
    uiListener: TaskListListener,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(uiState.tasks) { task ->
            TaskItem(
                task = task,
                onClick = { uiListener.onTaskClicked(task) }
            )
        }
    }
}

@Composable
private fun TaskItem(
    task: Task,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = task.content
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = task.creationTime.toString()
            )
        }
    }
}

@Composable
private fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .align(Alignment.Center)
        )
    }
}

// PREVIEWS

@Preview(
    showBackground = true
)
@Composable
internal fun TaskListUi_Loading() {
    TaskListUi(
        uiState = TaskListUiState.Loading,
        uiListener = emptyListener
    )
}

@Preview(
    showBackground = true
)
@Composable
internal fun TaskListUi_Empty() {
    TaskListUi(
        uiState = TaskListUiState.Ready(emptyList()),
        uiListener = emptyListener
    )
}

@Preview(
    showBackground = true
)
@Composable
internal fun TaskListUi_Ready() {
    TaskListUi(
        uiState = TaskListUiState.Ready(
            listOf(
                Task(
                    id = "123",
                    content = "Ulalal",
                    creationTime = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]")
                ),
                Task(
                    id = "124",
                    content = "Test",
                    creationTime = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]")
                ),
                Task(
                    id = "125",
                    content = "Test2",
                    creationTime = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]")
                ),
            )
        ),
        uiListener = emptyListener
    )
}

private val emptyListener = object : TaskListListener {
    override fun onShowSettingsClicked() = Unit
    override fun onTaskClicked(task: Task) = Unit
    override fun onAddTaskClicked() = Unit
}
