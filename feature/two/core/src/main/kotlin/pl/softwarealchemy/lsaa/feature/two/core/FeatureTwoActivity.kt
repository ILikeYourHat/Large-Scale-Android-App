package pl.softwarealchemy.lsaa.feature.two.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.android.ext.android.getKoin
import pl.softwarealchemy.lsaa.feature.one.contract.GreetingProvider

internal class FeatureTwoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val greetings = getKoin().getAll<GreetingProvider>()
            .map { it.sayHello() }
        setContent { FeatureTwoScreen(greetings = greetings) }
    }
}
