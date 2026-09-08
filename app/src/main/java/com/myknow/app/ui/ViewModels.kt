package com.myknow.app.ui

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import android.app.Application
import com.myknow.app.MyKnowApp
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device
import com.myknow.app.data.model.SearchHit
import com.myknow.app.data.repo.KnowledgeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private fun repo(app: Application): KnowledgeRepository =
    (app as MyKnowApp).repository

class HomeViewModel(app: Application) : AndroidViewModel(app) {
    val devices: StateFlow<List<Device>> = repo(app).observeDevices()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    val articles: StateFlow<List<Article>> = repo(app).observeArticles()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    val favorites: StateFlow<List<Device>> = repo(app).observeFavoriteDevices()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}

class CatalogViewModel(app: Application) : AndroidViewModel(app) {
    private val repository = repo(app)
    private val type = MutableStateFlow<String?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val devices: StateFlow<List<Device>> = type.flatMapLatest { selected ->
        if (selected.isNullOrBlank()) repository.observeDevices()
        else repository.observeDevices(selected)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setType(value: String?) {
        type.value = value
    }
}

class DeviceDetailViewModel(app: Application) : AndroidViewModel(app) {
    private val repository = repo(app)
    private val id = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val device: StateFlow<Device?> = id.flatMapLatest { key ->
        repository.observeDevice(key)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun setId(value: String) {
        id.value = value
    }

    fun toggleFavorite() {
        val key = id.value
        if (key.isBlank()) return
        viewModelScope.launch { repository.toggleDeviceFavorite(key) }
    }
}

class DocsViewModel(app: Application) : AndroidViewModel(app) {
    val articles: StateFlow<List<Article>> = repo(app).observeArticles()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}

class DocDetailViewModel(app: Application) : AndroidViewModel(app) {
    private val repository = repo(app)
    private val id = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val article: StateFlow<Article?> = id.flatMapLatest { key ->
        repository.observeArticle(key)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun setId(value: String) {
        id.value = value
    }
}

class SearchViewModel(app: Application) : AndroidViewModel(app) {
    private val repository = repo(app)
    val query = MutableStateFlow("")
    val results = MutableStateFlow<List<SearchHit>>(emptyList())

    fun onQueryChange(value: String) {
        query.value = value
        viewModelScope.launch {
            results.value = repository.search(value)
        }
    }
}
