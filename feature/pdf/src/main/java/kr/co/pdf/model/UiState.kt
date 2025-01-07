package kr.co.pdf.model

import android.graphics.Bitmap
import kotlinx.coroutines.CoroutineScope
import kr.co.ui.util.TopBarState
import kotlin.coroutines.EmptyCoroutineContext

internal data class UiState(
    val scope: CoroutineScope = CoroutineScope(EmptyCoroutineContext),
    val bitmaps: Map<Int, Bitmap> = emptyMap(),
    val topBarState: TopBarState = TopBarState(scope),
    val currentPage: Int = 1,
    val totalPage: Int = 1,
    val isLoading: Boolean = false
)