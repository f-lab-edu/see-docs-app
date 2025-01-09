package kr.co.model

import kr.co.ui.base.UiState

internal data class BookmarkUiState(
    val files: List<FileInfo>,
): UiState {
    companion object {
        val INIT = BookmarkUiState(
            files = listOf(FileInfo.INIT),
        )
    }
}