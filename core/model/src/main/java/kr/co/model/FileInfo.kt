package kr.co.model

import kr.co.model.FileInfo.Type.PDF
import java.time.LocalDateTime

data class FileInfo(
    val name: String,
    val path: String,
    val type: Type,
    val isDirectory: Boolean,
    val isHidden: Boolean,
    val size: Long,
    val createdAt: LocalDateTime,
    val lastModified: LocalDateTime
) {
    enum class Type {
        PDF,
        IMAGE,
        FOLDER
        ;

        companion object {
            fun from(extension: String): Type =
                when(extension) {
                    "pdf" -> PDF
                    "jpg", "jpeg", "png", "gif" -> IMAGE
                    else -> IMAGE
                }
        }
    }
    companion object {
        val DUMMY = FileInfo(
            name = "DUMMY",
            path = "",
            type = PDF,
            isDirectory = false,
            isHidden = false,
            size = 0,
            createdAt = LocalDateTime.now(),
            lastModified = LocalDateTime.now()
        )
    }
}
