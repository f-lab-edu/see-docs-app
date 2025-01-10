package kr.co.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.model.FileInfo
import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime
import java.time.LocalDateTime
import java.time.ZoneId

internal class FileManagerImpl: FileManager {
    override suspend fun readPDFOrDirectory(
        path: String,
    ): List<FileInfo> = withContext(Dispatchers.IO) {
        File(path).listFiles()?.filter { !it.isHidden && (it.isDirectory || it.extension == PDF) }
            ?.map {
                val attributes = getFileAttributes(it)
                FileInfo(
                    name = it.name,
                    path = it.path,
                    type = FileInfo.Type.from(it.extension),
                    isDirectory = it.isDirectory,
                    size = it.length(),
                    isHidden = it.isHidden,
                    createdAt = attributes.creationTime().toLocalDateTime(),
                    lastModified = attributes.lastModifiedTime().toLocalDateTime(),
                )
            } ?: emptyList()
    }

    private fun getFileAttributes(file: File): BasicFileAttributes =
        Files.readAttributes(file.toPath(), BasicFileAttributes::class.java)

    private fun FileTime.toLocalDateTime(): LocalDateTime =
        LocalDateTime.ofInstant(this.toInstant(), ZoneId.systemDefault())

    companion object {
        internal const val DEFAULT_STORAGE = "/storage/emulated/0"

        private const val PDF = "pdf"
    }
}