package com.myknow.app

import android.app.Application
import androidx.room.Room
import com.myknow.app.data.db.AppDatabase
import com.myknow.app.data.repo.KnowledgeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MyKnowApp : Application() {
    lateinit var repository: KnowledgeRepository
        private set

    private val appScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "myknow.db",
        ).fallbackToDestructiveMigration().build()
        repository = KnowledgeRepository(db.deviceDao(), db.articleDao())
        appScope.launch { repository.seedOfficialCatalog() }
    }
}
