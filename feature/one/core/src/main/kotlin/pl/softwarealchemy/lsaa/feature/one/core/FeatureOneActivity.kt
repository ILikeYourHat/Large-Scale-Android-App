package pl.softwarealchemy.lsaa.feature.one.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import pl.softwarealchemy.lsaa.feature.one.core.databinding.ActivityFeatureOneBinding
import pl.softwarealchemy.lsaa.feature.two.contract.FeatureTwoRouter

internal class FeatureOneActivity: AppCompatActivity() {

    private val binding by lazy { ActivityFeatureOneBinding.inflate(layoutInflater) }

    private val featureTwoRouter by inject<FeatureTwoRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = featureTwoRouter.toFeatureTwoActivity()
            startActivity(intent)
        }
    }
}
