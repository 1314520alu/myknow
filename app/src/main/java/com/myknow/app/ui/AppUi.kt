package com.myknow.app.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Article
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.myknow.app.data.SpecJson
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device
import com.myknow.app.data.model.DeviceType
import com.myknow.app.data.model.SearchHit
import com.myknow.app.data.model.SpecField
import com.myknow.app.ui.theme.Ink
import com.myknow.app.ui.theme.InkRaised

private object Routes {
    const val DEVICES = "devices"
    const val VIDEO = "video"
    const val DOCS = "docs"
    const val SEARCH = "search"
    const val DEVICE = "device/{id}"
    const val DOC = "doc/{id}"
    const val PLAYER = "player/{id}"
    fun device(id: String) = "device/$id"
    fun doc(id: String) = "doc/$id"
    fun player(id: String) = "player/$id"
}

@Composable
fun MyKnowAppRoot() {
    val nav = rememberNavController()
    val backStack by nav.currentBackStackEntryAsState()
    val route = backStack?.destination?.route.orEmpty()
    val showBar = route == Routes.DEVICES || route == Routes.DOCS || route == Routes.SEARCH || route == Routes.VIDEO

    Scaffold(
        containerColor = Ink,
        bottomBar = {
            if (showBar) {
                NavigationBar(containerColor = InkRaised) {
                    NavigationBarItem(
                        selected = route == Routes.DEVICES,
                        onClick = { nav.navigate(Routes.DEVICES) { launchSingleTop = true } },
                        icon = { Icon(Icons.Outlined.Inventory2, contentDescription = null) },
                        label = { Text("器件") },
                    )
                    NavigationBarItem(
                        selected = route == Routes.VIDEO,
                        onClick = { nav.navigate(Routes.VIDEO) { launchSingleTop = true } },
                        icon = { Icon(Icons.Outlined.Videocam, contentDescription = null) },
                        label = { Text("视频") },
                    )
                    NavigationBarItem(
                        selected = route == Routes.DOCS,
                        onClick = { nav.navigate(Routes.DOCS) { launchSingleTop = true } },
                        icon = { Icon(Icons.AutoMirrored.Outlined.Article, contentDescription = null) },
                        label = { Text("文档") },
                    )
                    NavigationBarItem(
                        selected = route == Routes.SEARCH,
                        onClick = { nav.navigate(Routes.SEARCH) { launchSingleTop = true } },
                        icon = { Icon(Icons.Outlined.Search, contentDescription = null) },
                        label = { Text("搜索") },
                    )
                }
            }
        },
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = Routes.VIDEO,
            modifier = Modifier.padding(padding),
        ) {
            composable(Routes.DEVICES) { DeviceListScreen(nav) }
            composable(Routes.VIDEO) { VideoSourceListScreen(nav) }
            composable(Routes.DOCS) { DocListScreen(nav) }
            composable(Routes.SEARCH) { SearchScreen(nav) }
            composable(
                Routes.DEVICE,
                arguments = listOf(navArgument("id") { type = NavType.StringType }),
            ) { entry ->
                DeviceDetailScreen(entry.arguments?.getString("id").orEmpty(), nav)
            }
            composable(
                Routes.DOC,
                arguments = listOf(navArgument("id") { type = NavType.StringType }),
            ) { entry ->
                DocDetailScreen(entry.arguments?.getString("id").orEmpty(), nav)
            }
            composable(
                Routes.PLAYER,
                arguments = listOf(navArgument("id") { type = NavType.StringType }),
            ) { entry ->
                VideoPlayerScreen(entry.arguments?.getString("id").orEmpty(), nav)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun DeviceListScreen(nav: NavHostController, vm: CatalogViewModel = viewModel()) {
    val devices by vm.devices.collectAsStateWithLifecycle()
    var selected by rememberSaveable { mutableStateOf("") }
    LaunchedEffect(selected) { vm.setType(selected.ifBlank { null }) }

    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Column {
                    Text("MyKnow", fontWeight = FontWeight.SemiBold)
                    Text("无人机器件资料", style = MaterialTheme.typography.bodySmall)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Ink),
        )
        FlowRow(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            FilterChip(
                selected = selected.isBlank(),
                onClick = { selected = "" },
                label = { Text("全部") },
                colors = FilterChipDefaults.filterChipColors(),
            )
            DeviceType.entries.filter { type ->
                devices.any { it.type == type.name } ||
                    type.name in setOf("PROPULSION", "MOTOR", "ESC", "PROPELLER", "CAMERA")
            }.distinct().forEach { type ->
                FilterChip(
                    selected = selected == type.name,
                    onClick = { selected = type.name },
                    label = { Text(type.shortLabel) },
                    leadingIcon = { Icon(type.icon, null, Modifier.size(16.dp)) },
                )
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(devices, key = { it.id }) { device ->
                DeviceCard(device) { nav.navigate(Routes.device(device.id)) }
            }
        }
    }
}

@Composable
private fun DeviceCard(device: Device, onClick: () -> Unit) {
    val type = device.deviceType
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = InkRaised),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(type.icon, null, tint = type.accent)
                Spacer(Modifier.width(8.dp))
                Text(type.label, color = type.accent, style = MaterialTheme.typography.labelLarge)
                Spacer(Modifier.weight(1f))
                if (device.favorite) {
                    Icon(Icons.Outlined.Star, null, tint = type.accent, modifier = Modifier.size(18.dp))
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(device.displayName, style = MaterialTheme.typography.titleMedium)
            Text(
                device.notes.lineSequence().firstOrNull().orEmpty(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DeviceDetailScreen(
    id: String,
    nav: NavHostController,
    vm: DeviceDetailViewModel = viewModel(),
) {
    LaunchedEffect(id) { vm.setId(id) }
    val device by vm.device.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val current = device

    Scaffold(
        containerColor = Ink,
        topBar = {
            TopAppBar(
                title = { Text(current?.model ?: "器件资料", maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "返回")
                    }
                },
                actions = {
                    IconButton(onClick = { vm.toggleFavorite() }) {
                        Icon(
                            if (current?.favorite == true) Icons.Outlined.Star else Icons.Outlined.StarBorder,
                            contentDescription = "收藏",
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Ink),
            )
        },
    ) { padding ->
        if (current == null) {
            Text("资料不存在", modifier = Modifier.padding(padding).padding(24.dp))
            return@Scaffold
        }
        val specs = SpecJson.decode(current.specsJson)
        LazyColumn(
            modifier = Modifier.padding(padding).fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                Text(current.brand, color = current.deviceType.accent, style = MaterialTheme.typography.labelLarge)
                Text(current.displayName, style = MaterialTheme.typography.headlineMedium)
            }
            item { SpecTable(specs) }
            item {
                Text("说明", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(6.dp))
                Text(current.notes, style = MaterialTheme.typography.bodyLarge)
            }
            if (current.datasheetUrl.isNotBlank()) {
                item {
                    TextButton(onClick = { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(current.datasheetUrl))) }) {
                        Icon(Icons.Outlined.OpenInNew, null)
                        Spacer(Modifier.width(8.dp))
                        Text("打开官方资料")
                    }
                }
            }
        }
    }
}

@Composable
private fun SpecTable(specs: List<SpecField>) {
    val context = LocalContext.current
    Card(colors = CardDefaults.cardColors(containerColor = InkRaised), shape = RoundedCornerShape(16.dp)) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text("技术参数", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(vertical = 8.dp))
            specs.forEachIndexed { index, spec ->
                val value = listOf(spec.value, spec.unit).filter { it.isNotBlank() }.joinToString(" ")
                val isLink = spec.value.startsWith("http")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(
                            if (isLink) Modifier.clickable {
                                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(spec.value)))
                            } else Modifier,
                        )
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(spec.key, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(0.4f))
                    Text(
                        if (isLink) "打开" else value.ifBlank { "—" },
                        fontFamily = if (isLink) FontFamily.SansSerif else FontFamily.Monospace,
                        fontWeight = FontWeight.Medium,
                        color = if (isLink) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(0.6f),
                    )
                }
                if (index != specs.lastIndex) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DocListScreen(nav: NavHostController, vm: DocsViewModel = viewModel()) {
    val articles by vm.articles.collectAsStateWithLifecycle()
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("文档") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Ink),
        )
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(articles, key = { it.id }) { article ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { nav.navigate(Routes.doc(article.id)) },
                    colors = CardDefaults.cardColors(containerColor = InkRaised),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(article.articleCategory.label, color = MaterialTheme.colorScheme.secondary, style = MaterialTheme.typography.labelLarge)
                        Spacer(Modifier.height(4.dp))
                        Text(article.title, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DocDetailScreen(id: String, nav: NavHostController, vm: DocDetailViewModel = viewModel()) {
    LaunchedEffect(id) { vm.setId(id) }
    val article by vm.article.collectAsStateWithLifecycle()
    Scaffold(
        containerColor = Ink,
        topBar = {
            TopAppBar(
                title = { Text(article?.title ?: "文档", maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "返回")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Ink),
            )
        },
    ) { padding ->
        val current = article ?: return@Scaffold
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
            item {
                Text(current.articleCategory.label, color = MaterialTheme.colorScheme.secondary)
                Spacer(Modifier.height(8.dp))
                Text(current.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                Text(current.body, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchScreen(nav: NavHostController, vm: SearchViewModel = viewModel()) {
    val query by vm.query.collectAsStateWithLifecycle()
    val results by vm.results.collectAsStateWithLifecycle()
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = vm::onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("搜电机、电调、H15、拉力、接线…") },
            leadingIcon = { Icon(Icons.Outlined.Search, null) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(),
        )
        Spacer(Modifier.height(12.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(results, key = { it.kind.name + it.id }) { hit ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable {
                        when (hit.kind) {
                            SearchHit.Kind.DEVICE -> nav.navigate(Routes.device(hit.id))
                            SearchHit.Kind.ARTICLE -> nav.navigate(Routes.doc(hit.id))
                        }
                    },
                    colors = CardDefaults.cardColors(containerColor = InkRaised),
                ) {
                    Column(Modifier.padding(14.dp)) {
                        Text(hit.typeLabel, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.secondary)
                        Text(hit.title, style = MaterialTheme.typography.titleMedium)
                        if (hit.subtitle.isNotBlank()) {
                            Text(hit.subtitle, maxLines = 2, overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
