package pl.softwarealchemy.lsaa.feature.tasks.list

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

internal class TaskListUiTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun empty() {
        paparazzi.snapshot { TaskListUi_Empty() }
    }

    @Test
    fun loading() {
        paparazzi.snapshot { TaskListUi_Loading() }
    }

    @Test
    fun ready() {
        paparazzi.snapshot { TaskListUi_Ready() }
    }
}
