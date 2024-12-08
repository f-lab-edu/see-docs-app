package kr.co.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kr.co.database.model.RecentFile

@Dao
interface RecentFileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recentFile: RecentFile)

    @Query("SELECT * FROM recent_file ORDER BY updatedAt DESC LIMIT 10")
    fun get(): Flow<List<RecentFile>>

    @Delete
    suspend fun delete(recentFile: RecentFile)

}