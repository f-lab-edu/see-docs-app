package kr.co.data.mapper

import kr.co.common.util.Mapper
import kr.co.database.model.BookmarkFile
import kr.co.database.model.FileType
import kr.co.model.FileInfo

internal class BookmarkFileMapper : Mapper<FileInfo, BookmarkFile> {
    override fun invoke(from: FileInfo): BookmarkFile =
        BookmarkFile(
            name = from.name,
            path = from.path,
            type = when (from.type) {
                FileInfo.Type.PDF -> FileType.PDF
                FileInfo.Type.IMAGE -> FileType.IMAGE
                FileInfo.Type.FOLDER -> FileType.FOLDER
            },
            size = from.size,
            createdAt = from.createdAt,
            lastModified = from.lastModified
        )
}
