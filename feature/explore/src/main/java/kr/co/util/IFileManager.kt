package kr.co.util

import kr.co.model.FileInfo

interface IFileManager {
    suspend fun readPDFOrDirectory(path: String): List<FileInfo>
}
