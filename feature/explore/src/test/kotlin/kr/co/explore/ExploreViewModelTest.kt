package kr.co.explore

import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kr.co.data.repository.RecentRepository
import kr.co.model.ExploreSideEffect
import kr.co.model.ExploreUiIntent
import kr.co.model.FileInfo
import kr.co.model.FileInfo.Type.PDF
import kr.co.util.FileManagerImpl
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

class ExploreViewModelTest {

    private lateinit var viewModel: ExploreViewModel
    private lateinit var recentRepository: RecentRepository
    private lateinit var fileManagerImpl: FileManagerImpl
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

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

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        recentRepository = mockk(relaxed = true)
        fileManagerImpl = mockk()
        viewModel = ExploreViewModel(recentRepository,fileManagerImpl)
    }

    @Test
    fun `Init intent 경로를 통한 파일 초기화`() = testScope.runTest {
        val path = "/path"
        val folders = listOf(
            FOLDER_DUMMY
        )
        val files = listOf(
            PDF_DUMMY,
            PDF_DUMMY
        )

        coEvery { fileManagerImpl.readPDFOrDirectory(path) } returns files + folders

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
        val file = PDF_DUMMY

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
        val folder = FOLDER_DUMMY

        viewModel.handleIntent(ExploreUiIntent.ClickFolder(folder))

        advanceUntilIdle()

        viewModel.sideEffect.first().let {
            assert(it is ExploreSideEffect.NavigateToFolder)
            assert((it as ExploreSideEffect.NavigateToFolder).path == folder.path)
        }
    }
}