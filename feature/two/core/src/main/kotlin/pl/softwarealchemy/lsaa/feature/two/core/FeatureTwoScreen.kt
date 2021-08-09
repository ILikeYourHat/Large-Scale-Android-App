package pl.softwarealchemy.lsaa.feature.two.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
@Suppress("UnusedPrivateMember")
private fun PreviewFeatureTwoScreen() {
    FeatureTwoScreen(
        listOf(
            "Dzień dobry",
            "Guten tag!"
        )
    )
}

@Composable
internal fun FeatureTwoScreen(greetings: List<String>) {
    MaterialTheme {
        Scaffold(
            topBar = { Toolbar() },
            content = { Content(greetings = greetings) }
        )
    }
}

@Composable
private fun Toolbar() {
    TopAppBar(
        title = { Text("Jetpack") },
        elevation = 2.dp
    )
}

@Composable
private fun Content(greetings: List<String>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(greetings) { greeting ->
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = greeting
            )
        }
    }
}
