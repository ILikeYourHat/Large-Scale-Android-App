package pl.softwarealchemy.lsaa.feature.tasks.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import assertk.assertThat
import assertk.assertions.containsOnly
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.ZonedDateTime
import java.util.UUID

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
internal class TasksDatabaseTest {

    private lateinit var db: TasksDatabase
    private lateinit var dao: TasksDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TasksDatabase::class.java).build()
        dao = db.taskDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun `should be empty on start`() = runTest {
        assertThat(dao.getAll()).isEmpty()
    }

    @Test
    fun `should allow adding one task to database`() = runTest {
        val task = Task(
            id = "123",
            content = "test",
            creationTime = ZonedDateTime.now()
        )

        dao.insertAll(task)

        assertThat(dao.getAll()).containsOnly(task)
    }

    @Test
    fun `should allow adding multiple tasks to database`() = runTest {
        val tasks = (1..5).toList().map { index ->
            Task(
                id = UUID.randomUUID().toString(),
                content = "test $index",
                creationTime = ZonedDateTime.now().plusMinutes(index.toLong())
            )
        }

        dao.insertAll(*tasks.toTypedArray())

        assertThat(dao.getAll()).hasSize(5)
    }
}
