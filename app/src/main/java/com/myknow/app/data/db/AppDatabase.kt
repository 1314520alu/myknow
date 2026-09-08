package com.myknow.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device

@Database(
    entities = [Device::class, Article::class],
    version = 2,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
    abstract fun articleDao(): ArticleDao
}
