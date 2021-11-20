package pl.softwarealchemy.lsaa.feature.one.core.tasklist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.softwarealchemy.lsaa.db.tasks.contract.Task

@Composable
internal fun TaskListScreen(
    uiState: TaskListUiState,
    onClick: (String) -> Unit
) {
    MaterialTheme {
        Scaffold(
            topBar = { Toolbar() },
            content = { Content(uiState, onClick) }
        )
    }
}

@Composable
private fun Toolbar() {
    TopAppBar(
        title = { Text("My tasks") },
        elevation = 2.dp
    )
}

@Composable
private fun Content(
    uiState: TaskListUiState,
    onClick: (String) -> Unit
) {
    when (uiState) {
        TaskListUiState.Loading -> Loading()
        is TaskListUiState.Ready -> {
            if (uiState.tasks.isEmpty()) {
                EmptyContent()
            } else {
                ActualContent(uiState, onClick)
            }
        }
    }
}

@Composable
private fun EmptyContent() {
    Box(
        modifier = Modifier.fillMaxSize()
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
    onClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(uiState.tasks) { task ->
            TaskItem(task = task, onClick)
        }
    }
}

@Composable
private fun TaskItem(
    task: Task,
    onClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(task.id) }
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
private fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .align(Alignment.Center)
        )
    }
}
