package pl.softwarealchemy.lsaa.feature.settings.licenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.softwarealchemy.lsaa.feature.settings.R
import pl.softwarealchemy.lsaa.feature.settings.licenses.repository.LibraryLicense

@Composable
internal fun LicensesUi(
    licenses: List<LibraryLicense> = emptyList()
) {
    MaterialTheme {
        Scaffold(
            topBar = { Toolbar() },
            content = { Content(licenses = licenses) }
        )
    }
}

@Composable
private fun Toolbar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.licenses_title)) },
        elevation = 2.dp
    )
}

@Composable
private fun Content(licenses: List<LibraryLicense>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(licenses) { Item(it) }
    }
}

@Composable
private fun Item(license: LibraryLicense) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = license.libraryName
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = license.licenseName
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun Preview_Normal() {
    LicensesUi()
}
