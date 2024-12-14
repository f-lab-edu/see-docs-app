package kr.co.data.mapper

import kr.co.common.util.Mapper
import kr.co.database.model.BookmarkFile
import kr.co.database.model.FileType
import kr.co.model.FileInfo

internal class BookmarkMapper : Mapper<FileInfo, BookmarkFile> {
    override fun invoke(p1: FileInfo): BookmarkFile =
        BookmarkFile(
            name = p1.name,
            path = p1.path,
            type = when (p1.type) {
                FileInfo.Type.PDF -> FileType.PDF
                FileInfo.Type.IMAGE -> FileType.IMAGE
                FileInfo.Type.FOLDER -> FileType.PDF
            },
            size = p1.size,
            createdAt = p1.createdAt,
            lastModified = p1.lastModified
        )
}