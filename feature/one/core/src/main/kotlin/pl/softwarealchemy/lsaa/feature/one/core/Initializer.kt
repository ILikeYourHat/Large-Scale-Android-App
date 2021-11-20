package pl.softwarealchemy.lsaa.feature.one.core

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.softwarealchemy.lsaa.core.di.ModuleInitializer
import pl.softwarealchemy.lsaa.feature.one.contract.GreetingProvider
import pl.softwarealchemy.lsaa.feature.one.core.tasklist.TaskListViewModel

@Suppress("unused")
internal class Initializer : ModuleInitializer(
    module {
        single(named("polish")) { GreetingProvider { "Dzień dobry" } }

        viewModel { TaskListViewModel(get()) }
    }
)
