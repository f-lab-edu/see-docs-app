package kr.co.database.converter

import androidx.room.TypeConverter
import kr.co.database.model.RecentFile

internal class EnumConverter {

    @TypeConverter
    fun fromType(value: RecentFile.Type): Int =
        value.ordinal

    @TypeConverter
    fun toType(value: Int): RecentFile.Type =
        RecentFile.Type.entries[value]
}