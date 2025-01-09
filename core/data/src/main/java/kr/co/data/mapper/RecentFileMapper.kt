package kr.co.data.mapper

import kr.co.common.util.Mapper
import kr.co.database.model.RecentFile
import kr.co.model.FileInfo

internal class RecentFileMapper : Mapper<FileInfo, RecentFile> {
    override fun invoke(from: FileInfo): RecentFile =
        RecentFile(
            name = from.name,
            path = from.path,
            type = when (from.type) {
                FileInfo.Type.PDF -> RecentFile.Type.PDF
                FileInfo.Type.IMAGE -> RecentFile.Type.IMAGE
                FileInfo.Type.FOLDER -> RecentFile.Type.PDF
            },
            size = from.size,
            createdAt = from.createdAt,
            lastModified = from.lastModified
        )

    fun toFileInfo(recentFile: RecentFile): FileInfo =
        FileInfo(
            name = recentFile.name,
            path = recentFile.path,
            type = FileInfo.Type.from(recentFile.type.name.lowercase()),
            isDirectory = false,
            isHidden = false,
            size = recentFile.size,
            createdAt = recentFile.createdAt,
            lastModified = recentFile.lastModified
        )
}