package kr.co.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kr.co.model.FileInfo.Type
import java.time.LocalDateTime

@Entity(tableName = "recent_file")
data class RecentFile(
    val name: String,
    @PrimaryKey val path: String,
    val type: Type,
    val size: Long,
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
