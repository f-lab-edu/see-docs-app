package kr.co.pdf.model

import android.graphics.Bitmap
import kr.co.ui.util.TopBarState

internal data class PdfUiState(
    val bitmaps: Map<Int, Bitmap> = emptyMap(),
    val topBarState: TopBarState? = null,
    val currentPage: Int = 1,
    val totalPage: Int = 1,
    val isLoading: Boolean = false
)