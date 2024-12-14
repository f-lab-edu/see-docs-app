package kr.co.database.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime

internal class LocalDateTimeConverter {

    @TypeConverter
    fun fromString(value: String): LocalDateTime =
        LocalDateTime.parse(value)

    @TypeConverter
    fun toString(value: LocalDateTime): String =
        value.toString()
}