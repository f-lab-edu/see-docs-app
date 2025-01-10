package kr.co.model

import kr.co.ui.base.UiState

internal data class ExploreUiState(
    val path: String,
    val folders: List<FileInfo>,
    val files: List<FileInfo>,
): UiState {
    companion object {
        val INIT = ExploreUiState(
            path = "",
            folders = emptyList(),
            files = emptyList(),
        )
    }
}
