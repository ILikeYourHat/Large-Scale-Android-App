package pl.softwarealchemy.lsaa.feature.one.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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
private fun PreviewFeatureOneScreen() {
    FeatureOneScreen {}
}

@Composable
internal fun FeatureOneScreen(onClick: () -> Unit) {
    MaterialTheme {
        Scaffold(
            topBar = { Toolbar() },
            content = { Content(onClick = onClick) }
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
private fun Content(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello World!"
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Geeks for Geeks")
        }
    }
}
