package pl.softwarealchemy.lsaa.feature.settings.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.softwarealchemy.lsaa.feature.settings.R

@Composable
internal fun SettingsUi(
    uiListener: SettingsListener
) {
    MaterialTheme {
        Scaffold(
            topBar = { Toolbar() },
            content = { paddingValues ->
                Content(
                    modifier = Modifier.fillMaxSize()
                        .padding(paddingValues),
                    uiListener = uiListener
                )
            }
        )
    }
}

@Composable
private fun Toolbar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.settings_title)) },
        elevation = 2.dp
    )
}

@Composable
private fun Content(
    modifier: Modifier,
    uiListener: SettingsListener
) {
    Row(
        modifier = modifier
    ) {
        Item(
            text = stringResource(R.string.licenses_title),
            onClick = { uiListener.onLicensesClicked() }
        )
    }
}

@Composable
private fun Item(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = text
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun Preview_Normal() {
    SettingsUi(
        uiListener = emptyListener
    )
}

private val emptyListener = object : SettingsListener {
    override fun onLicensesClicked() = Unit
}
