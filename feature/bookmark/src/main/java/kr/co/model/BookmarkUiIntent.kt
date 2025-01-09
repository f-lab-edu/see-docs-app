package kr.co.model

import kr.co.ui.base.UiIntent

internal sealed interface BookmarkUiIntent: UiIntent {
    data object Init : BookmarkUiIntent
    data class ClickFile(val file: FileInfo) : BookmarkUiIntent
}