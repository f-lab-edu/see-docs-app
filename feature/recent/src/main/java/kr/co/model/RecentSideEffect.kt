package kr.co.model

import kr.co.ui.base.UiSideEffect

internal sealed interface RecentSideEffect : UiSideEffect {
    data class NavigateToPdf(val path: String) : RecentSideEffect
}