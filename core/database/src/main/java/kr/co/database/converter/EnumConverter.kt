package kr.co.database.converter

import androidx.room.TypeConverter
import kr.co.database.model.FileType

internal class EnumConverter {

    @TypeConverter
    fun fromType(value: FileType): Int =
        value.ordinal

    @TypeConverter
    fun toType(value: Int): FileType =
        FileType.entries[value]
}