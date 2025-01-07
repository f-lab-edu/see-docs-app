package kr.co.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.database.dao.RecentFileDao
import kr.co.database.model.RecentFile

@Database(
    entities = [
        RecentFile::class
    ],
    version = 1,
    exportSchema = true
)

abstract class SeeDocsDatabase : RoomDatabase() {

    abstract fun recentFileDao(): RecentFileDao
}