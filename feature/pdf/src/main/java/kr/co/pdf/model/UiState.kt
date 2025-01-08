package kr.co.pdf.model

import android.graphics.Bitmap
import kotlinx.coroutines.CoroutineScope
import kr.co.ui.util.TopBarState
import kotlin.coroutines.EmptyCoroutineContext

internal data class UiState(
    val bitmaps: Map<Int, Bitmap> = emptyMap(),
    val topBarState: TopBarState? = null,
    val currentPage: Int = 1,
    val totalPage: Int = 1,
    val isLoading: Boolean = false
)