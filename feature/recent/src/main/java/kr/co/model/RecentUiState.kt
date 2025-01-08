package kr.co.model

import kr.co.ui.base.UiState

internal data class RecentUiState(
    val files: List<FileInfo>,
): UiState {
    companion object {
        val INIT = RecentUiState(
            files = emptyList(),
        )
    }
}
