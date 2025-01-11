package kr.co.util

import kr.co.model.FileInfo

internal fun interface FileManager {
    suspend fun readPDFOrDirectory(path: String): List<FileInfo>
}
