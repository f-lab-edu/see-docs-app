package kr.co.model

import android.graphics.pdf.PdfRenderer
import kr.co.ui.base.UiIntent
import kr.co.ui.util.TopBarState

internal sealed interface PdfUiIntent: UiIntent {
    data class Init(
        val renderer: PdfRenderer,
        val topBarState: TopBarState
    ) : PdfUiIntent

    data object ShowTopBar : PdfUiIntent
    data class ChangePage(val page: Int) : PdfUiIntent
    data class RenderPage(val page: Int) : PdfUiIntent
}