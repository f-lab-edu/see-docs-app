package kr.co.model

import kr.co.ui.base.UiIntent

internal sealed interface ExploreUiIntent: UiIntent {
    data class Init(val path: String): ExploreUiIntent
    data class ClickFile(val file: FileInfo): ExploreUiIntent
    data class ClickFolder(val folder: FileInfo): ExploreUiIntent
}