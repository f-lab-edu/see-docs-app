package kr.co.model

internal data class BookmarkUiState(
    val files: List<FileInfo>,
) {
    companion object {
        val EMPTY = BookmarkUiState(
            files = listOf(FileInfo.DUMMY),
        )
    }
}
