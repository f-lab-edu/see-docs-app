package kr.co.model

import kr.co.ui.base.UiSideEffect

internal sealed interface BookmarkSideEffect : UiSideEffect {
    data class NavigateToPdf(val path: String) : BookmarkSideEffect
}