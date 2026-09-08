package com.myknow.app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Query("SELECT * FROM devices ORDER BY updatedAt DESC")
    fun observeAll(): Flow<List<Device>>

    @Query("SELECT * FROM devices WHERE type = :type ORDER BY brand, model")
    fun observeByType(type: String): Flow<List<Device>>

    @Query("SELECT * FROM devices WHERE favorite = 1 ORDER BY updatedAt DESC")
    fun observeFavorites(): Flow<List<Device>>

    @Query("SELECT * FROM devices WHERE id = :id")
    fun observeById(id: String): Flow<Device?>

    @Query("SELECT * FROM devices WHERE id = :id")
    suspend fun getById(id: String): Device?

    @Query(
        """
        SELECT * FROM devices
        WHERE brand LIKE '%' || :q || '%'
           OR model LIKE '%' || :q || '%'
           OR tags LIKE '%' || :q || '%'
           OR notes LIKE '%' || :q || '%'
           OR specsJson LIKE '%' || :q || '%'
        ORDER BY updatedAt DESC
        """,
    )
    suspend fun search(q: String): List<Device>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(device: Device)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(devices: List<Device>)

    @Update
    suspend fun update(device: Device)

    @Query("DELETE FROM devices WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT COUNT(*) FROM devices")
    suspend fun count(): Int
}

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles ORDER BY updatedAt DESC")
    fun observeAll(): Flow<List<Article>>

    @Query("SELECT * FROM articles WHERE id = :id")
    fun observeById(id: String): Flow<Article?>

    @Query("SELECT * FROM articles WHERE id = :id")
    suspend fun getById(id: String): Article?

    @Query(
        """
        SELECT * FROM articles
        WHERE title LIKE '%' || :q || '%'
           OR body LIKE '%' || :q || '%'
           OR tags LIKE '%' || :q || '%'
        ORDER BY updatedAt DESC
        """,
    )
    suspend fun search(q: String): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(articles: List<Article>)

    @Query("DELETE FROM articles WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT COUNT(*) FROM articles")
    suspend fun count(): Int
}
