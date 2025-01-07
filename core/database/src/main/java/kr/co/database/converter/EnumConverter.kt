package kr.co.database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
internal class EnumConverter {

    @TypeConverter
    fun <T: Enum<T>> fromEnum(value: T): String =
        value.name

    @TypeConverter
    fun <T: Enum<T>> toEnum(value: String, enumClass: Class<T>): T? =
        enumClass.enumConstants?.firstOrNull { it.name == value }
}