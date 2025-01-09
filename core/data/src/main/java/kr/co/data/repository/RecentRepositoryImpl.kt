package kr.co.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.co.data.mapper.FileInfoMapper
import kr.co.data.mapper.RecentFileMapper
import kr.co.database.dao.RecentFileDao
import kr.co.model.FileInfo

internal class RecentRepositoryImpl(
    private val dao: RecentFileDao,
    private val toRecent: RecentFileMapper,
    private val toFileInfo: FileInfoMapper
) : RecentRepository {
    override suspend fun insert(recentFile: FileInfo) {
        dao.insert(
            recentFile.let(toRecent)
        )
    }

    override fun get(): Flow<List<FileInfo>> =
        dao.get().map {
            it.map(toFileInfo)
        }

    override suspend fun delete(recentFile: FileInfo) {
        dao.delete(recentFile.let(toRecent))
    }
}