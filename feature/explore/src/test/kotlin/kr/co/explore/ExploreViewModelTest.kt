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
import kr.co.testing.util.assertsEquals
import kr.co.testing.util.testWithItem
import kr.co.util.FileManager
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals


internal class ExploreViewModelTest {

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
        val path = "/path"
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

            assertsEquals(
                state.path to path,
                state.files to files,
                state.folders to folders,
                state.files.size to files.size,
                state.folders.size to folders.size
            )
        }
    }

    @Test
    fun `Given a file when ClickFile intent is handled then navigate to pdf`() = runTest {
        val file = PDF_DUMMY

        recentRepository.insert(file)

        viewModel.handleIntent(ExploreUiIntent.ClickFile(file))

        recentRepository.insert(file)

        viewModel.sideEffect.testWithItem {
            assert(this is ExploreSideEffect.NavigateToPdf)
            assertEquals((this as ExploreSideEffect.NavigateToPdf).path,file.path)
        }
    }

    @Test
    fun `Given a folder when ClickFolder intent is handled then navigate to folder`() = runTest {
        val folder = FOLDER_DUMMY

        viewModel.handleIntent(ExploreUiIntent.ClickFolder(folder))

        viewModel.sideEffect.testWithItem {
            assert(this is ExploreSideEffect.NavigateToFolder)
            assertEquals((this as ExploreSideEffect.NavigateToFolder).path,folder.path)
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