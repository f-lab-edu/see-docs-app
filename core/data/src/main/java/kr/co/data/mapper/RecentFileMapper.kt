package kr.co.data.mapper

import kr.co.common.util.Mapper
import kr.co.database.model.RecentFile
import kr.co.model.FileInfo

internal class RecentFileMapper : Mapper<FileInfo, RecentFile> {
    override fun invoke(p1: FileInfo): RecentFile =
        RecentFile(
            name = p1.name,
            path = p1.path,
            type = when (p1.type) {
                FileInfo.Type.PDF -> RecentFile.Type.PDF
                FileInfo.Type.IMAGE -> RecentFile.Type.IMAGE
                FileInfo.Type.FOLDER -> RecentFile.Type.PDF
            },
            size = p1.size,
        )

    fun toFileInfo(recentFile: RecentFile): FileInfo =
        FileInfo(
            name = recentFile.name,
            path = recentFile.path,
            type = FileInfo.Type.from(recentFile.type.name.lowercase()),
            isDirectory = false,
            isHidden = false,
            size = recentFile.size,
        )
}