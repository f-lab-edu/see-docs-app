package kr.co.pdf.model

import android.graphics.pdf.PdfRenderer

internal sealed class UiIntent {
    data class Init(val renderer: PdfRenderer) : UiIntent()
    data object ShowTopBar : UiIntent()
    data class ChangePage(val page: Int) : UiIntent()
    data class RenderPage(val page: Int) : UiIntent()
}