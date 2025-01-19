package kr.co.data.mapper

import junit.framework.TestCase.assertEquals
import kr.co.data.dummy.TestDummy
import kr.co.testing.util.assertsEquals
import org.junit.Test

internal class MapperTest {

    private val bookmarkFileMapper = BookmarkFileMapper()
    private val recentFileMapper = RecentFileMapper()
    private val fileInfoMapper = FileInfoMapper()

    @Test
    fun `Given a file when invoke is called then bookmark file is returned`() {
        val file = TestDummy.PDF_DUMMY
        val bookmarkFile = TestDummy.BOOKMARK_DUMMY

        val result = bookmarkFileMapper(file)

        assertEquals(bookmarkFile, result)
    }

    @Test
    fun `Given a file when invoke is called then recent file is returned`() {
        val file = TestDummy.PDF_DUMMY
        val recentFile = TestDummy.RECENT_DUMMY

        val result = recentFileMapper(file)

        assertEquals(recentFile, result)
    }

    @Test
    fun `Given a file when invoke is called then file info is returned`() {
        val bookmarkFile = TestDummy.BOOKMARK_DUMMY
        val recentFile = TestDummy.RECENT_DUMMY
        val file = TestDummy.PDF_DUMMY

        val result = fileInfoMapper(bookmarkFile)
        val result2 = fileInfoMapper(recentFile)

        assertsEquals(
            file to result,
            file to result2
        )
    }
}