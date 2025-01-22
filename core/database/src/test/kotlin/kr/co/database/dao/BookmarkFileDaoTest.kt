package kr.co.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kr.co.database.SeeDocsDatabase
import kr.co.database.dummy.DataBaseDummy
import kr.co.database.model.BookmarkFile
import kr.co.testing.util.testWithItem
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

internal class BookmarkFileDaoTest {

    private lateinit var database: SeeDocsDatabase
    private lateinit var bookmarkFileDao: BookmarkFileDao

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            context,
            SeeDocsDatabase::class.java
        ).allowMainThreadQueries().build()

        bookmarkFileDao = database.bookmarkFileDao()
    }

    @After
    @Throws(IOException::class)
    fun close() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun bookmarkInsert() = runTest {
        val bookmarkFile = DataBaseDummy.BOOKMARK_DUMMY

        bookmarkFileDao.insert(bookmarkFile)

        bookmarkFileDao.get().testWithItem {
            assertEquals(listOf(bookmarkFile), this)
        }
    }

    @Test
    @Throws(Exception::class)
    fun bookmarkDelete() = runTest {
        val bookmarkFile = DataBaseDummy.BOOKMARK_DUMMY

        bookmarkFileDao.insert(bookmarkFile)
        bookmarkFileDao.delete(bookmarkFile)

        bookmarkFileDao.get().testWithItem {
            assertEquals(emptyList<BookmarkFile>(), this)
        }
    }
}