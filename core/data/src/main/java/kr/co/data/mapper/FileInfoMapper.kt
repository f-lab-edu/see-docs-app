package kr.co.data.mapper

import kr.co.common.util.Mapper
import kr.co.database.model.LocalFile
import kr.co.model.FileInfo

internal class FileInfoMapper : Mapper<LocalFile, FileInfo>{
    override fun invoke(p1: LocalFile): FileInfo =
        FileInfo(
            name = p1.name,
            path = p1.path,
            type = FileInfo.Type.from(p1.type.name.lowercase()),
            isDirectory = false,
            isHidden = false,
            size = p1.size,
            createdAt = p1.createdAt,
            lastModified = p1.lastModified
        )
}