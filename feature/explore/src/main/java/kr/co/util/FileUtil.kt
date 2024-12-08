package kr.co.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.model.FileInfo
import java.io.File

internal suspend fun readPDFOrDirectory(
    path: String,
): List<FileInfo> = withContext(Dispatchers.IO) {
    File(path).listFiles()?.filter { !it.isHidden && (it.isDirectory || it.extension == PDF) }
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

internal const val DEFAULT_STORAGE = "/storage/emulated/0"

private const val PDF = "pdf"