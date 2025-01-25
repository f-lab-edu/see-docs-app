package kr.co.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kr.co.database.RoomTestRule
import kr.co.database.SeeDocsDatabase
import kr.co.database.dummy.DataBaseDummy
import kr.co.database.model.BookmarkFile
import kr.co.testing.util.testWithItem
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
internal class BookmarkFileDaoTest {

    private lateinit var bookmarkFileDao: BookmarkFileDao

    @get: Rule
    val roomTestRule = RoomTestRule()

    private val db: SeeDocsDatabase = roomTestRule.db

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        bookmarkFileDao = db.bookmarkFileDao()
    }

    @After
    @Throws(IOException::class)
    fun close() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun `Given bookmarkFile When insert Then get bookmarkFile`() = runTest {
        val bookmarkFile = DataBaseDummy.BOOKMARK_DUMMY

        bookmarkFileDao.insert(bookmarkFile)

        bookmarkFileDao.get().testWithItem {
            assertEquals(listOf(bookmarkFile), this)
        }
    }

    @Test
    @Throws(Exception::class)
    fun `Given bookmarkFile When delete Then get emptyList`() = runTest {
        val bookmarkFile = DataBaseDummy.BOOKMARK_DUMMY

        bookmarkFileDao.insert(bookmarkFile)
        bookmarkFileDao.delete(bookmarkFile)

        bookmarkFileDao.get().testWithItem {
            assertEquals(emptyList<BookmarkFile>(), this)
        }
    }
}