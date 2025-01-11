package kr.co.testing.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kr.co.data.repository.RecentRepository
import kr.co.model.FileInfo

class TestRecentRepository: RecentRepository {

    private val recentFilesFlow: MutableStateFlow<List<FileInfo>> =
        MutableStateFlow(emptyList())

    override suspend fun insert(recentFile: FileInfo) {
        recentFilesFlow.update { it + recentFile }
    }

    override fun get(): Flow<List<FileInfo>> =
        recentFilesFlow

    override suspend fun delete(recentFile: FileInfo) {
        recentFilesFlow.update { it - recentFile }
    }
}