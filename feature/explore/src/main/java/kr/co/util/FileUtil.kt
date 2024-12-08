package kr.co.util

import kr.co.model.FileInfo
import java.io.File

internal fun readPDFOrDirectory(
    path: String,
): List<FileInfo> =
    File(path).listFiles()?.filter { !it.isHidden && (it.isDirectory || it.extension == "pdf") }?.map {
        FileInfo(
            name = it.name,
            path = it.path,
            type = FileInfo.Type.from(it.extension),
            isDirectory = it.isDirectory,
            size = it.length(),
            isHidden = it.isHidden
        )
    }?: emptyList()