package kr.co.model

internal data class RecentUiState(
    val files: List<FileInfo>,
) {
    companion object {
        val EMPTY = RecentUiState(
            files = emptyList(),
        )
    }
}
