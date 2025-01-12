package kr.co.testing.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kr.co.data.repository.BookmarkRepository
import kr.co.model.FileInfo

class TestBookmarkRepository: BookmarkRepository {

    private val bookmarkFilesFlow: MutableStateFlow<List<FileInfo>> =
        MutableStateFlow(emptyList())

    override suspend fun insert(bookmarkFile: FileInfo) {
        bookmarkFilesFlow.update { it + bookmarkFile }
    }

    override fun get(): Flow<List<FileInfo>> =
        bookmarkFilesFlow

    override suspend fun delete(bookmarkFile: FileInfo) {
        bookmarkFilesFlow.update { it - bookmarkFile }
    }
}