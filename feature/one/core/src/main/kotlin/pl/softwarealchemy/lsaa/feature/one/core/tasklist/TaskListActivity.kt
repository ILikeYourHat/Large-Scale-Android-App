package pl.softwarealchemy.lsaa.feature.one.core.tasklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.softwarealchemy.lsaa.feature.two.contract.FeatureTwoRouter

internal class TaskListActivity : ComponentActivity() {

    private val viewModel: TaskListViewModel by viewModel()
    private val featureTwoRouter: FeatureTwoRouter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.screenState.observe(this) { uiState ->
            setContent { TaskListScreen(uiState) { onButtonClicked() } }
        }
        viewModel.onCreate()
    }

    private fun onButtonClicked() {
        val intent = featureTwoRouter.toFeatureTwoActivity()
        startActivity(intent)
    }
}
