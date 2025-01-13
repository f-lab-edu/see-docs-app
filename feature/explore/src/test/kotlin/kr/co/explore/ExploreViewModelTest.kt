package kr.co.explore

import app.cash.turbine.test
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import kr.co.model.ExploreSideEffect
import kr.co.model.ExploreUiIntent
import kr.co.model.FileInfo
import kr.co.model.FileInfo.Type.PDF
import kr.co.testing.repository.TestRecentRepository
import kr.co.testing.rule.CoroutineTestRule
import kr.co.util.FileManager
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals


class ExploreViewModelTest {

    @get: Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: ExploreViewModel

    private val recentRepository = TestRecentRepository()

    @MockK
    private lateinit var fileManager: FileManager

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = ExploreViewModel(recentRepository, fileManager)
    }

    @Test
    fun `Given a path when Init intent is handled then state is updated`() = runTest {
        val path = "/path/test"
        val folders = listOf(
            FOLDER_DUMMY
        )
        val files = listOf(
            PDF_DUMMY,
            PDF_DUMMY
        )

        coEvery { fileManager.readPDFOrDirectory(path) } returns folders + files

        viewModel.handleIntent(ExploreUiIntent.Init(path))

        viewModel.uiState.test {
            val state = awaitItem()
            assert(state.path == path)
            assertEquals(state.files.size, files.size)
            assertEquals(state.folders.size, folders.size)
            assert(state.folders == folders)
            assert(state.files == files)
        }
    }

    @Test
    fun `Given a file when ClickFile intent is handled then navigate to pdf`() = runTest {
        val file = PDF_DUMMY

        recentRepository.insert(file)

        viewModel.handleIntent(ExploreUiIntent.ClickFile(file))

        recentRepository.insert(file)

        viewModel.sideEffect.test {
            awaitItem().also {
                assert(it is ExploreSideEffect.NavigateToPdf)
                assert((it as ExploreSideEffect.NavigateToPdf).path == file.path)
            }
        }
    }

    @Test
    fun `Given a folder when ClickFolder intent is handled then navigate to folder`() = runTest {
        val folder = FOLDER_DUMMY

        viewModel.handleIntent(ExploreUiIntent.ClickFolder(folder))

        viewModel.sideEffect.test {
            awaitItem().also {
                assert(it is ExploreSideEffect.NavigateToFolder)
                assert((it as ExploreSideEffect.NavigateToFolder).path == folder.path)
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