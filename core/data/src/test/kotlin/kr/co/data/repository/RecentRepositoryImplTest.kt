package kr.co.data.repository

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kr.co.data.mapper.FileInfoMapper
import kr.co.data.mapper.RecentFileMapper
import kr.co.database.dao.RecentFileDao
import kr.co.database.model.FileType
import kr.co.database.model.RecentFile
import kr.co.model.FileInfo
import kr.co.testing.util.testWithItem
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime

internal class RecentRepositoryImplTest {

    @MockK
    private lateinit var dao: RecentFileDao

    @MockK
    private lateinit var toRecent: RecentFileMapper

    @MockK
    private lateinit var toFileInfo: FileInfoMapper

    private lateinit var repository: RecentRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = RecentRepositoryImpl(dao, toRecent, toFileInfo)
    }

    @Test
    fun `Given a file when insert is called then dao insert is called`() = runTest {
        val file = PDF_DUMMY
        val recentFile = RECENT_DUMMY

        every { toRecent(file) } returns recentFile
        coEvery { dao.insert(recentFile) } returns Unit

        repository.insert(file)

        coVerify { dao.insert(recentFile) }
    }

    @Test
    fun `Given a unit when get is called then dao get is called`() = runTest {
        val recentFiles = listOf(RECENT_DUMMY)
        val files = listOf(PDF_DUMMY)

        every { toFileInfo(RECENT_DUMMY) } returns PDF_DUMMY
        every { dao.get() } returns flowOf(recentFiles)

        repository.get().testWithItem {
            assertEquals(files, this)
        }

        verify { dao.get() }
    }

    @Test
    fun `Given a file when delete is called then dao delete is called`() = runTest {
        val file = PDF_DUMMY
        val recentFile = RECENT_DUMMY

        every { toRecent(file) } returns recentFile
        coEvery { dao.delete(recentFile) } returns Unit

        repository.delete(file)

        coVerify { dao.delete(recentFile) }
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

        val RECENT_DUMMY = RecentFile(
            name = "DUMMY.pdf",
            path = "",
            type = FileType.PDF,
            size = 0,
            createdAt = LocalDateTime.of(2024,6,2,2,0),
            lastModified = LocalDateTime.of(2024,6,2,2,0)
        )
    }
}