package kr.co.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.co.database.converter.EnumConverter
import kr.co.database.converter.LocalDateTimeConverter
import kr.co.database.dao.BookmarkFileDao
import kr.co.database.dao.RecentFileDao
import kr.co.database.model.BookmarkFile
import kr.co.database.model.RecentFile

@Database(
    entities = [
        RecentFile::class,
        BookmarkFile::class
    ],
    version = 2,
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

    abstract fun bookmarkFileDao(): BookmarkFileDao
}