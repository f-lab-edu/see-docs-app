package kr.co.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.model.FileInfo
import java.io.File

internal suspend fun readPDFOrDirectory(
    path: String,
): List<FileInfo> = withContext(Dispatchers.IO) {
    File(path).listFiles()?.filter { !it.isHidden && (it.isDirectory || it.extension == "pdf") }
        ?.map {
            FileInfo(
                name = it.name,
                path = it.path,
                type = FileInfo.Type.from(it.extension),
                isDirectory = it.isDirectory,
                size = it.length(),
                isHidden = it.isHidden
            )
        } ?: emptyList()
}