package kr.co.explore

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.mockkStatic
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kr.co.model.FileInfo
import kr.co.util.readPDFOrDirectory
import org.junit.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.time.LocalDateTime
import java.time.ZoneId.systemDefault
import kotlin.io.path.createTempDirectory
import kotlin.io.path.pathString

class FileUtilTest {
    @Test
    fun `존재하지 않는 디렉터리이면 빈 리스트를 반환`() = runTest {
        val invalidPath = "/this/path/does/not/exist"

        val result = readPDFOrDirectory(invalidPath)

        assertEquals(0, result.size)
    }

    @Test
    fun `빈 디렉터리라면 빈 리스트를 반환`() = runTest {
        val tempDir = createTempDirectory(prefix = "emptyDirTest")

        val result = readPDFOrDirectory(tempDir.pathString)

        assertEquals(0, result.size)
    }

    @Test
    fun `readPDFOrDirectory 함수 테스트`() = runTest {

        val mockDirectory = mockk<File>()
        val mockFile = mockk<File>()
        val mockAttributes = mockk<BasicFileAttributes>()

        every { mockDirectory.isHidden } returns false
        every { mockDirectory.isDirectory } returns true
        every { mockDirectory.extension } returns ""
        every { mockDirectory.name } returns "testDir"
        every { mockDirectory.path } returns "/test/testDir"
        every { mockDirectory.length() } returns 0L

        every { mockFile.isHidden } returns false
        every { mockFile.isDirectory } returns false
        every { mockFile.extension } returns "pdf"
        every { mockFile.name } returns "testFile.pdf"
        every { mockFile.path } returns "/test/testFile.pdf"
        every { mockFile.length() } returns 1024L

        every { mockAttributes.creationTime() } returns mockk {
            every { toInstant() } returns LocalDateTime.now().minusDays(1).atZone(systemDefault()).toInstant()
        }
        every { mockAttributes.lastModifiedTime() } returns mockk {
            every { toInstant() } returns LocalDateTime.now().atZone(systemDefault()).toInstant()
        }

        mockkConstructor(File::class)
        every { anyConstructed<File>().listFiles() } returns arrayOf(mockDirectory, mockFile)

        mockkStatic("java.nio.file.Files")
        every { Files.readAttributes(any(), BasicFileAttributes::class.java) } returns mockAttributes

        val result = readPDFOrDirectory("/test")

        assertEquals(2, result.size)
        assertEquals("testDir", result[0].name)
        assertEquals("testFile.pdf", result[1].name)
        assertEquals(FileInfo.Type.PDF, result[1].type)
        assertEquals(1024L, result[1].size)

        verify { Files.readAttributes(any(), BasicFileAttributes::class.java) }
        verify { mockDirectory.listFiles() }
    }
}