package kr.co.pdf

import android.graphics.pdf.PdfRenderer
import kotlinx.coroutines.flow.collectLatest
import kr.co.pdf.model.PdfUiIntent
import kr.co.pdf.model.PdfUiState
import kr.co.ui.base.BaseMviViewModel
import kr.co.ui.util.TopBarState
import kr.co.util.PdfToBitmap

internal class PdfViewModel : BaseMviViewModel<PdfUiState, PdfUiIntent>(PdfUiState()) {

    private var pdfToBitmap: PdfToBitmap? = null

    override fun handleIntent(intent: PdfUiIntent) {
        when (intent) {
            is PdfUiIntent.Init -> init(intent.renderer, intent.topBarState)
            is PdfUiIntent.ShowTopBar -> showTopBar()
            is PdfUiIntent.ChangePage -> changePage(intent.page)
            is PdfUiIntent.RenderPage -> renderPage(intent.page)
        }
    }

    private fun init(
        renderer: PdfRenderer,
        topBarState: TopBarState,
    ) {
        pdfToBitmap = PdfToBitmap(renderer)

        reduce {
            copy(
                totalPage = renderer.pageCount,
                topBarState = topBarState
            )
        }

        launch {
            pdfToBitmap?.bitmap?.collectLatest { bitmaps ->
                reduce {
                    copy(bitmaps = bitmaps)
                }
            }
        }
    }

    private fun showTopBar() {
        uiState.value.topBarState?.show()
    }

    private fun changePage(page: Int) {
        reduce {
            copy(currentPage = page)
        }
    }

    private fun renderPage(page: Int) {
        reduce {
            copy(isLoading = true)
        }

        launch {
            pdfToBitmap?.renderPage(page)
        }.invokeOnCompletion {
            reduce {
                copy(isLoading = false)
            }
        }
    }
}