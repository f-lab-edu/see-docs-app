	package kr.co.data.mapper

import kr.co.common.util.Mapper
import kr.co.database.model.LocalFile
import kr.co.model.FileInfo

internal class FileInfoMapper : Mapper<LocalFile, FileInfo>{
    override fun invoke(from: LocalFile): FileInfo =
        FileInfo(
            name = from.name,
            path = from.path,
            type = FileInfo.Type.from(from.type.name.lowercase()),
            isDirectory = false,
            isHidden = false,
            size = from.size,
            createdAt = from.createdAt,
            lastModified = from.lastModified
        )
}
