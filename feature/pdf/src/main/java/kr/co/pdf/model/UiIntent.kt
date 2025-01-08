package kr.co.pdf.model

import android.graphics.pdf.PdfRenderer
import kr.co.ui.util.TopBarState

internal sealed class UiIntent {
    data class Init(
        val renderer: PdfRenderer,
        val topBarState: TopBarState
    ) : UiIntent()

    data object ShowTopBar : UiIntent()
    data class ChangePage(val page: Int) : UiIntent()
    data class RenderPage(val page: Int) : UiIntent()
}