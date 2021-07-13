package pl.softwarealchemy.lsaa.feature.two.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.getKoin
import pl.softwarealchemy.lsaa.feature.one.contract.GreetingProvider
import pl.softwarealchemy.lsaa.feature.two.core.databinding.ActivityFeatureTwoBinding

internal class FeatureTwoActivity: AppCompatActivity() {

    private val binding by lazy { ActivityFeatureTwoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val greetings = getKoin().getAll<GreetingProvider>()
        binding.greetingsTextView.text = greetings.joinToString("\n") { it.sayHello() }
    }
}
