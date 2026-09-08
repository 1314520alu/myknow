package com.myknow.app.data.repo

import com.myknow.app.data.db.ArticleDao
import com.myknow.app.data.db.DeviceDao
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device
import com.myknow.app.data.model.SearchHit
import com.myknow.app.data.seed.SeedData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class KnowledgeRepository(
    private val deviceDao: DeviceDao,
    private val articleDao: ArticleDao,
) {
    fun observeDevices(): Flow<List<Device>> = deviceDao.observeAll()
    fun observeDevices(type: String): Flow<List<Device>> = deviceDao.observeByType(type)
    fun observeFavoriteDevices(): Flow<List<Device>> = deviceDao.observeFavorites()
    fun observeDevice(id: String): Flow<Device?> = deviceDao.observeById(id)
    fun observeArticles(): Flow<List<Article>> = articleDao.observeAll()
    fun observeArticle(id: String): Flow<Article?> = articleDao.observeById(id)

    suspend fun seedOfficialCatalog() {
        SeedData.devices().forEach { seeded ->
            val previous = deviceDao.getById(seeded.id)
            deviceDao.upsert(seeded.copy(favorite = previous?.favorite ?: seeded.favorite))
        }
        SeedData.articles().forEach { seeded ->
            val previous = articleDao.getById(seeded.id)
            articleDao.upsert(seeded.copy(favorite = previous?.favorite ?: seeded.favorite))
        }
    }

    suspend fun toggleDeviceFavorite(id: String) {
        val device = deviceDao.getById(id) ?: return
        deviceDao.update(
            device.copy(
                favorite = !device.favorite,
                updatedAt = System.currentTimeMillis(),
            ),
        )
    }

    suspend fun search(query: String): List<SearchHit> {
        val q = query.trim()
        if (q.isEmpty()) return emptyList()
        val devices = deviceDao.search(q)
        val articles = articleDao.search(q)
        return devices.map { it.toHit() } + articles.map { it.toHit() }
    }

    suspend fun recentDevices(limit: Int = 8): List<Device> {
        return deviceDao.observeAll().first().take(limit)
    }

    private fun Device.toHit() = SearchHit(
        id = id,
        kind = SearchHit.Kind.DEVICE,
        title = displayName,
        subtitle = notes.lineSequence().firstOrNull().orEmpty(),
        typeLabel = deviceType.label,
    )

    private fun Article.toHit() = SearchHit(
        id = id,
        kind = SearchHit.Kind.ARTICLE,
        title = title,
        subtitle = body.lineSequence().firstOrNull().orEmpty(),
        typeLabel = articleCategory.label,
    )
}
