package kr.co.database.dummy

import kr.co.database.model.BookmarkFile
import kr.co.database.model.FileType
import kr.co.database.model.RecentFile
import java.time.LocalDateTime

internal object DataBaseDummy {

    val BOOKMARK_DUMMY = BookmarkFile(
        name = "DUMMY.pdf",
        path = "",
        type = FileType.PDF,
        size = 0,
        createdAt = LocalDateTime.of(2024,6,2,2,0),
        lastModified = LocalDateTime.of(2024,6,2,2,0)
    )

    val RECENT_DUMMY = RecentFile(
        name = "DUMMY.pdf",
        path = "",
        type = FileType.PDF,
        size = 0,
        createdAt = LocalDateTime.of(2024,6,2,2,0),
        lastModified = LocalDateTime.of(2024,6,2,2,0)
    )
}