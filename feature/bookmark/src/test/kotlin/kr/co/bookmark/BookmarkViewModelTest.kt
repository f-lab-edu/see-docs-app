package kr.co.bookmark

import app.cash.turbine.test
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kr.co.data.repository.BookmarkRepository
import kr.co.data.repository.RecentRepository
import kr.co.model.BookmarkSideEffect
import kr.co.model.BookmarkUiIntent
import kr.co.model.FileInfo
import kr.co.model.FileInfo.Type.PDF
import kr.co.testing.rule.CoroutineTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

internal class BookmarkViewModelTest {

    @get: Rule
    val coroutineTestRule = CoroutineTestRule()

    @MockK
    private lateinit var bookmarkRepository: BookmarkRepository

    @MockK
    private lateinit var recentRepository: RecentRepository

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = BookmarkViewModel(bookmarkRepository,recentRepository)
    }

    @Test
    fun `Given a Unit when Init intent is handled then state is updated`() = runTest {
        val dummy = listOf(PDF_DUMMY, PDF_DUMMY)

        coEvery { bookmarkRepository.get() } returns flowOf(dummy)

        viewModel.handleIntent(BookmarkUiIntent.Init)

        viewModel.uiState.test {
            val state = awaitItem()
            assertEquals(state.files, dummy)
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