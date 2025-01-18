package kr.co.data.repository

import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.just
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kr.co.data.mapper.BookmarkMapper
import kr.co.data.mapper.FileInfoMapper
import kr.co.database.dao.BookmarkFileDao
import kr.co.database.model.BookmarkFile
import kr.co.database.model.FileType
import kr.co.model.FileInfo
import kr.co.testing.util.testWithItem
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

internal class BookmarkRepositoryImplTest {

    @MockK
    private lateinit var dao: BookmarkFileDao

    @MockK
    private lateinit var toBookmark : BookmarkMapper

    @MockK
    private lateinit var toFileInfo : FileInfoMapper

    private lateinit var repository: BookmarkRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = BookmarkRepositoryImpl(dao, toBookmark, toFileInfo)
    }

    @Test
    fun `Given a file when insert is called then dao insert is called`() = runTest {
        val file = PDF_DUMMY
        val bookmarkFile = BOOKMARK_DUMMY

        coEvery { toBookmark(file) } returns bookmarkFile
        coEvery { dao.insert(bookmarkFile) } just Runs

        repository.insert(file)

        coVerify { dao.insert(bookmarkFile) }
    }

    @Test
    fun `Given a unit when get is called then dao get is called`() = runTest {
        val bookmarkFiles = listOf(BOOKMARK_DUMMY)
        val files = listOf(PDF_DUMMY)

        coEvery { dao.get() } returns flowOf(bookmarkFiles)
        coEvery { toFileInfo(BOOKMARK_DUMMY) } returns PDF_DUMMY

        repository.get().testWithItem {
            assertEquals(this, files)
        }

        coVerify { dao.get() }
    }

    @Test
    fun `Given a file when delete is called then dao delete is called`() = runTest {
        val file = PDF_DUMMY
        val bookmarkFile = BOOKMARK_DUMMY

        coEvery { toBookmark(file) } returns bookmarkFile
        coEvery { dao.delete(bookmarkFile) } just Runs

        repository.delete(file)

        coVerify { dao.delete(bookmarkFile) }
    }

    private companion object {
        val PDF_DUMMY = FileInfo(
            name = "DUMMY.pdf",
            path = "",
            type = FileInfo.Type.PDF,
            isDirectory = false,
            isHidden = false,
            size = 0,
            createdAt = LocalDateTime.of(2024,6,2,2,0),
            lastModified = LocalDateTime.of(2024,6,2,2,0)
        )

        val BOOKMARK_DUMMY = BookmarkFile(
            name = "DUMMY.pdf",
            path = "",
            type = FileType.PDF,
            size = 0,
            createdAt = LocalDateTime.of(2024,6,2,2,0),
            lastModified = LocalDateTime.of(2024,6,2,2,0)
        )
    }
}