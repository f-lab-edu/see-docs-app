package kr.co.database.model

import java.time.LocalDateTime

open class LocalFile(
    open val name: String,
    open val path: String,
    open val type: FileType,
    open val size: Long,
    open val updatedAt: LocalDateTime = LocalDateTime.now(),
    open val createdAt: LocalDateTime,
    open val lastModified: LocalDateTime
)