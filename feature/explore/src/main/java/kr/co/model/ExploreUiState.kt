package kr.co.model

import kr.co.ui.base.UiState

internal data class ExploreUiState(
    val path: String,
    val files: List<FileInfo>,
): UiState {
    companion object {
        val INIT = ExploreUiState(
            path = "",
            files = emptyList(),
        )
    }
}
