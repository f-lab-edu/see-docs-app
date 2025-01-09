package kr.co.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.co.database.converter.EnumConverter
import kr.co.database.converter.LocalDateTimeConverter
import kr.co.database.dao.RecentFileDao
import kr.co.database.model.RecentFile

@Database(
    entities = [
        RecentFile::class
    ],
    version = 1,
    exportSchema = true
)

@TypeConverters(
    value = [
        LocalDateTimeConverter::class,
        EnumConverter::class
    ]
)
abstract class SeeDocsDatabase : RoomDatabase() {

    abstract fun recentFileDao(): RecentFileDao
}