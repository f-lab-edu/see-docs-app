package kr.co.testing.dummy

import kr.co.model.FileInfo
import kr.co.model.FileInfo.Type.PDF
import java.time.LocalDateTime

val PDF_DUMMY = FileInfo(
    name = "DUMMY.pdf",
    path = "",
    type = PDF,
    isDirectory = false,
    isHidden = false,
    size = 0,
    createdAt = LocalDateTime.now(),
    lastModified = LocalDateTime.now()
)

val FOLDER_DUMMY = FileInfo(
    name = "DUMMY",
    path = "",
    type = PDF,
    isDirectory = true,
    isHidden = false,
    size = 0,
    createdAt = LocalDateTime.now(),
    lastModified = LocalDateTime.now()
)