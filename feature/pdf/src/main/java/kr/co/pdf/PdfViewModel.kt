package kr.co.pdf

import android.graphics.pdf.PdfRenderer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.co.pdf.model.UiIntent
import kr.co.pdf.model.UiState
import kr.co.util.PdfToBitmap

internal class PdfViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState(viewModelScope))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private var pdfToBitmap: PdfToBitmap? = null

    fun handleIntent(intent: UiIntent) {
        when (intent) {
            is UiIntent.Init -> init(intent.renderer)
            is UiIntent.ShowTopBar -> showTopBar()
            is UiIntent.ChangePage -> changePage(intent.page)
            is UiIntent.RenderPage -> renderPage(intent.page)
        }
    }

    private fun init(renderer: PdfRenderer) {
        pdfToBitmap = PdfToBitmap(renderer)

        _uiState.update {
            it.copy(
                totalPage = renderer.pageCount
            )
        }
    }

    private fun showTopBar() {
        _uiState.value.topBarState.show()
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