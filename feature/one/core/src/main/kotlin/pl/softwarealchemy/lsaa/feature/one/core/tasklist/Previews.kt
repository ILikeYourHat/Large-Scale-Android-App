package pl.softwarealchemy.lsaa.feature.one.core.tasklist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pl.softwarealchemy.lsaa.db.tasks.contract.Task
import java.time.ZonedDateTime

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
@Suppress("UnusedPrivateMember")
private fun TaskListScreen_Loading() {
    TaskListScreen(TaskListUiState.Loading) {}
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
@Suppress("UnusedPrivateMember")
private fun TaskListScreen_Empty() {
    TaskListScreen(TaskListUiState.Ready(emptyList())) {}
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
@Suppress("UnusedPrivateMember")
private fun TaskListScreen_Ready() {
    TaskListScreen(TaskListUiState.Ready(
        listOf(
            Task("123", "Ulalalal", ZonedDateTime.now()),
            Task("124", "Test", ZonedDateTime.now()),
            Task("125", "Test2", ZonedDateTime.now()),
        )
    )) {}
}
