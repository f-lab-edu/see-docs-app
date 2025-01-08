package kr.co.pdf.model

import android.graphics.pdf.PdfRenderer
import kr.co.ui.util.TopBarState

internal sealed class PdfUiIntent {
    data class Init(
        val renderer: PdfRenderer,
        val topBarState: TopBarState
    ) : PdfUiIntent()

    data object ShowTopBar : PdfUiIntent()
    data class ChangePage(val page: Int) : PdfUiIntent()
    data class RenderPage(val page: Int) : PdfUiIntent()
}