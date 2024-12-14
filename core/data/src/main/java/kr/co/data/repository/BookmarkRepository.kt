package kr.co.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.model.FileInfo

interface BookmarkRepository {
    suspend fun insert(bookmarkFile: FileInfo)
    fun get(): Flow<List<FileInfo>>
    suspend fun delete(bookmarkFile: FileInfo)
}