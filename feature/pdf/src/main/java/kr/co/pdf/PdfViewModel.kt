package kr.co.pdf

import android.graphics.pdf.PdfRenderer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.co.pdf.model.PdfUiIntent
import kr.co.pdf.model.PdfUiState
import kr.co.ui.util.TopBarState
import kr.co.util.PdfToBitmap

internal class PdfViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PdfUiState())
    val uiState: StateFlow<PdfUiState> = _uiState.asStateFlow()

    private var pdfToBitmap: PdfToBitmap? = null

    fun handleIntent(intent: PdfUiIntent) {
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

        _uiState.update {
            it.copy(
                totalPage = renderer.pageCount,
                topBarState = topBarState
            )
        }
    }

    private fun showTopBar() {
        _uiState.value.topBarState?.show()
    }

    private fun changePage(page: Int) {
        _uiState.update {
            it.copy(currentPage = page)
        }
    }

    private fun renderPage(page: Int) {
        _uiState.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            pdfToBitmap?.renderPage(page)

            pdfToBitmap?.bitmap?.collect { bitmaps ->
                _uiState.update {
                    it.copy(bitmaps = bitmaps)
                }
            }

            _uiState.update {
                it.copy(isLoading = false)
            }
        }
    }
}