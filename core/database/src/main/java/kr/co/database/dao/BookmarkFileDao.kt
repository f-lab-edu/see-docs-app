package kr.co.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kr.co.database.model.BookmarkFile

@Dao
interface BookmarkFileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recentFile: BookmarkFile)

    @Query("SELECT * FROM bookmark_file ORDER BY updatedAt DESC LIMIT 10")
    fun get(): Flow<List<BookmarkFile>>

    @Delete
    suspend fun delete(recentFile: BookmarkFile)

}