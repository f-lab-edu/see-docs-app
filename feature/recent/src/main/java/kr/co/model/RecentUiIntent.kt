package kr.co.model

import kr.co.ui.base.UiIntent

internal sealed interface RecentUiIntent: UiIntent {
    data class ClickFile(val file: FileInfo) : RecentUiIntent
}