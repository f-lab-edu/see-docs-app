package kr.co.pdf

import android.graphics.pdf.PdfRenderer
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kr.co.model.PdfUiIntent
import kr.co.testing.rule.CoroutineTestRule
import kr.co.testing.util.assertsEquals
import kr.co.testing.util.testWithItem
import kr.co.ui.util.TopBarState
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class PdfViewModelTest {

    @get: Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var viewModel: PdfViewModel
    private val renderer = mockk<PdfRenderer>()
    private val mockTopBarState = mockk<TopBarState>()

    @Before
    fun setup() {
        viewModel = PdfViewModel()
    }

    @Test
    fun `Given renderer, when init, then update uiState`() = runTest {
        every { renderer.pageCount } returns 10

        viewModel.handleIntent(PdfUiIntent.Init(renderer, mockTopBarState))

        viewModel.uiState.testWithItem {
            assertsEquals(
                10 to totalPage,
                mockTopBarState to topBarState
            )
        }
    }

    @Test
    fun `Given page, when changePage, then update uiState`() = runTest {
        val page = 5
        viewModel.handleIntent(PdfUiIntent.ChangePage(page))

        viewModel.uiState.testWithItem {
            assertEquals(page, currentPage)
        }
    }

}