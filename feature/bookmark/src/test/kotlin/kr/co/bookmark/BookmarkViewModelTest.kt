package kr.co.bookmark

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import kr.co.model.BookmarkSideEffect
import kr.co.model.BookmarkUiIntent
import kr.co.model.FileInfo
import kr.co.model.FileInfo.Type.PDF
import kr.co.testing.repository.TestBookmarkRepository
import kr.co.testing.repository.TestRecentRepository
import kr.co.testing.rule.CoroutineTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime

internal class BookmarkViewModelTest {

    @get: Rule
    val coroutineTestRule = CoroutineTestRule()

    private val bookmarkRepository = TestBookmarkRepository()
    private val recentRepository = TestRecentRepository()

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setup() {
        viewModel = BookmarkViewModel(bookmarkRepository,recentRepository)
    }

    @Test
    fun `Given a Unit when Init intent is handled then state is updated`() = runTest {
        viewModel.handleIntent(BookmarkUiIntent.Init)

        viewModel.uiState.test {
            val state = awaitItem()
            assert(state.files.isEmpty())
        }
    }

    @Test
    fun `Given a file when ClickFile intent is handled then navigate to pdf`() = runTest {
        val file = PDF_DUMMY

        viewModel.handleIntent(BookmarkUiIntent.ClickFile(file))

        viewModel.sideEffect.test {
            awaitItem().also {
                assert(it is BookmarkSideEffect.NavigateToPdf)
                assert((it as BookmarkSideEffect.NavigateToPdf).path == file.path)
            }
        }
    }

    companion object {
        val PDF_DUMMY = FileInfo(
            name = "DUMMY.pdf",
            path = "",
            type = PDF,
            isDirectory = false,
            isHidden = false,
            size = 0,
            createdAt = LocalDateTime.now(),
            lastModified = LocalDateTime.now()
        )

        val FOLDER_DUMMY = FileInfo(
            name = "DUMMY",
            path = "",
            type = PDF,
            isDirectory = true,
            isHidden = false,
            size = 0,
            createdAt = LocalDateTime.now(),
            lastModified = LocalDateTime.now()
        )
    }
}