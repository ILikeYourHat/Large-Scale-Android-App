@file:Suppress("TooManyFunctions") // TODO
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.softwarealchemy.lsaa.feature.tasks.db.Task
import java.time.ZonedDateTime

@Composable
internal fun TaskListUi(
    uiState: TaskListUiState,
    onItemClick: (String) -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    MaterialTheme {
        Scaffold(
            topBar = { Toolbar() },
            content = { Content(uiState, onItemClick) },
            floatingActionButton = { Fab(onAddClick) }
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
private fun Fab(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { onClick() }
    ) {
        Icon(Icons.Filled.Add, "")
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

// PREVIEWS

@Preview(
    showBackground = true
)
@Composable
private fun TaskListScreen_Loading() {
    TaskListUi(
        TaskListUiState.Loading
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun TaskListScreen_Empty() {
    TaskListUi(
        TaskListUiState.Ready(emptyList())
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun TaskListScreen_Ready() {
    TaskListUi(
        TaskListUiState.Ready(
            listOf(
                Task("123", "Ulalalal", ZonedDateTime.now()),
                Task("124", "Test", ZonedDateTime.now()),
                Task("125", "Test2", ZonedDateTime.now()),
            )
        )
    )
}
