package kr.co.data.repository

import kr.co.model.FileInfo
import kotlinx.coroutines.flow.Flow

interface RecentRepository {
    suspend fun insert(recentFile: FileInfo)
    fun get(): Flow<List<FileInfo>>
    suspend fun delete(recentFile: FileInfo)
}
