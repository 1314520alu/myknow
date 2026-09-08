package com.myknow.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class SpecField(
    val key: String,
    val value: String,
    val unit: String = "",
)

@Entity(tableName = "devices")
data class Device(
    @PrimaryKey val id: String,
    val type: String,
    val brand: String,
    val model: String,
    val specsJson: String,
    val notes: String,
    val tags: String,
    val datasheetUrl: String,
    val favorite: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
) {
    val deviceType: DeviceType get() = DeviceType.fromName(type)

    val displayName: String
        get() = listOf(brand, model).filter { it.isNotBlank() }.joinToString(" ").ifBlank { "未命名器件" }

    val tagList: List<String>
        get() = tags.split(",", "，", " ")
            .map { it.trim() }
            .filter { it.isNotBlank() }
}

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey val id: String,
    val title: String,
    val category: String,
    val body: String,
    val tags: String,
    val favorite: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
) {
    val articleCategory: ArticleCategory
        get() = ArticleCategory.entries.firstOrNull { it.name == category } ?: ArticleCategory.OTHER

    val tagList: List<String>
        get() = tags.split(",", "，", " ")
            .map { it.trim() }
            .filter { it.isNotBlank() }
}

data class SearchHit(
    val id: String,
    val kind: Kind,
    val title: String,
    val subtitle: String,
    val typeLabel: String,
) {
    enum class Kind { DEVICE, ARTICLE }
}
