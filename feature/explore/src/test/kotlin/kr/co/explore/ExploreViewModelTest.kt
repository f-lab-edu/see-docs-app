package kr.co.explore

import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kr.co.data.repository.RecentRepository
import kr.co.model.ExploreSideEffect
import kr.co.model.ExploreUiIntent
import kr.co.model.FileInfo
import kr.co.util.FileManager
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ExploreViewModelTest {

    private lateinit var viewModel: ExploreViewModel
    private lateinit var recentRepository: RecentRepository
    private lateinit var fileManager: FileManager
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        recentRepository = mockk(relaxed = true)
        fileManager = mockk()
        viewModel = ExploreViewModel(recentRepository,fileManager)
    }

    @Test
    fun `Init intent 경로를 통한 파일 초기화`() = testScope.runTest {
        val path = "/path"
        val folders = listOf(
            FileInfo.FOLDER_DUMMY
        )
        val files = listOf(
            FileInfo.PDF_DUMMY,
            FileInfo.PDF_DUMMY
        )

        coEvery { fileManager.readPDFOrDirectory(path) } returns files + folders

        viewModel.handleIntent(ExploreUiIntent.Init(path))

        advanceUntilIdle()

        viewModel.uiState.value.let { state ->
            assert(state.path == path)
            assertEquals(state.files.size, files.size)
            assertEquals(state.folders.size, folders.size)
            assert(state.folders == folders)
            assert(state.files == files)
        }
    }

    @Test
    fun `ClickFile Repository에 insert 후 PDF 화면으로 이동`() = testScope.runTest {
        val file = FileInfo.PDF_DUMMY

        coEvery { recentRepository.insert(file) } just Runs

        viewModel.handleIntent(ExploreUiIntent.ClickFile(file))

        advanceUntilIdle()

        coVerify { recentRepository.insert(file) }

        viewModel.sideEffect.first().let {
            assert(it is ExploreSideEffect.NavigateToPdf)
            assert((it as ExploreSideEffect.NavigateToPdf).path == file.path)
        }
    }

    @Test
    fun `ClickFolder Folder 화면으로 이동`() = testScope.runTest {
        val folder = FileInfo.FOLDER_DUMMY

        viewModel.handleIntent(ExploreUiIntent.ClickFolder(folder))

        advanceUntilIdle()

        viewModel.sideEffect.first().let {
            assert(it is ExploreSideEffect.NavigateToFolder)
            assert((it as ExploreSideEffect.NavigateToFolder).path == folder.path)
        }
    }
}