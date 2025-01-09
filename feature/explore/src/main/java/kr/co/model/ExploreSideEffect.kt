package kr.co.model

import kr.co.ui.base.UiSideEffect

internal sealed interface ExploreSideEffect: UiSideEffect {
    data class NavigateToFolder(val path: String) : ExploreSideEffect
    data class NavigateToPdf(val path: String) : ExploreSideEffect
}