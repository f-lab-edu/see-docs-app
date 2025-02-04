package kr.co.recent

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kr.co.data.repository.RecentRepository
import kr.co.model.FileInfo
import kr.co.model.FileInfo.Type.PDF
import kr.co.model.RecentSideEffect
import kr.co.model.RecentUiIntent
import kr.co.testing.rule.CoroutineTestRule
import kr.co.testing.util.testWithItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

internal class RecentViewModelTest {

    @get: Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: RecentViewModel

    @MockK
    private lateinit var recentRepository: RecentRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = RecentViewModel(recentRepository)
    }

    @Test
    fun `Given a Unit when Init intent is handled then state is updated`() = runTest {
        val dummy = listOf(PDF_DUMMY, PDF_DUMMY)

        coEvery { recentRepository.get() } returns flowOf(dummy)

        viewModel.handleIntent(RecentUiIntent.Init)

        viewModel.uiState.testWithItem {
            assertEquals(dummy, files)
        }
    }

    @Test
    fun `Given a file when ClickFile intent is handled then navigate to pdf`() = runTest {
        coEvery { recentRepository.insert(PDF_DUMMY) } returns Unit

        viewModel.handleIntent(RecentUiIntent.ClickFile(PDF_DUMMY))

        viewModel.sideEffect.testWithItem {
            assert(this is RecentSideEffect.NavigateToPdf)
            assertEquals(PDF_DUMMY.path, (this as RecentSideEffect.NavigateToPdf).path)
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
    }
}