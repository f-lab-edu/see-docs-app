package kr.co.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.co.data.mapper.BookmarkMapper
import kr.co.data.mapper.FileInfoMapper
import kr.co.database.dao.BookmarkFileDao
import kr.co.model.FileInfo

internal class BookmarkRepositoryImpl(
    private val dao: BookmarkFileDao,
    private val toBookmark: BookmarkMapper,
    private val toFileInfo: FileInfoMapper,
) : BookmarkRepository {
    override suspend fun insert(bookmarkFile: FileInfo) =
        dao.insert(bookmarkFile.let(toBookmark))

    override fun get(): Flow<List<FileInfo>> =
        dao.get().map {
            it.map(toFileInfo)
        }

    override suspend fun delete(bookmarkFile: FileInfo) {
        dao.delete(bookmarkFile.let(toBookmark))
    }
}