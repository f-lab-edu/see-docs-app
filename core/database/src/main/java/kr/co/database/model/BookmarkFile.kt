package kr.co.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "bookmark_file")
data class BookmarkFile(
    override val name: String,
    @PrimaryKey override val path: String,
    override val type: FileType,
    override val size: Long,
    override val updatedAt: LocalDateTime = LocalDateTime.now(),
    override val createdAt: LocalDateTime,
    override val lastModified: LocalDateTime
): LocalFile(name, path, type, size, updatedAt, createdAt, lastModified)