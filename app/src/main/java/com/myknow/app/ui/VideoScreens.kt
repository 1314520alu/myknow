package com.myknow.app.ui

import android.view.WindowManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import com.myknow.app.data.model.VideoSource
import com.myknow.app.ui.theme.Ink
import com.myknow.app.ui.theme.InkRaised

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoSourceListScreen(nav: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Column {
                    Text("视频源")
                    Text("点 ZR10 拉流", style = MaterialTheme.typography.bodySmall)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Ink),
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(VideoSource.catalog, key = { it.id }) { source ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { nav.navigate("player/${source.id}") },
                    colors = CardDefaults.cardColors(containerColor = InkRaised),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(source.brand, color = MaterialTheme.colorScheme.secondary, style = MaterialTheme.typography.labelLarge)
                        Text(source.name, style = MaterialTheme.typography.titleMedium)
                        Text(source.rtspUrl, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(source.note, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoPlayerScreen(sourceId: String, nav: NavHostController) {
    val source = VideoSource.byId(sourceId)
    Scaffold(
        containerColor = Ink,
        topBar = {
            TopAppBar(
                title = { Text(source?.name ?: "预览") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "返回")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Ink),
            )
        },
    ) { padding ->
        if (source == null) {
            Text("没有这个视频源", modifier = Modifier.padding(padding).padding(24.dp))
            return@Scaffold
        }
        Column(Modifier.padding(padding).fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            RtspPlayer(url = source.rtspUrl, modifier = Modifier.fillMaxWidth().aspectRatio(16f / 9f))
            Text("地址 ${source.rtspUrl}", style = MaterialTheme.typography.bodyMedium)
            Text(source.note, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun RtspPlayer(url: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val activity = context as? android.app.Activity
    val player = remember(url) {
        ExoPlayer.Builder(context).build().apply {
            val mediaSource = RtspMediaSource.Factory()
                .setForceUseRtpTcp(true)
                .setTimeoutMs(10_000)
                .createMediaSource(MediaItem.fromUri(url))
            setMediaSource(mediaSource)
            prepare()
            playWhenReady = true
        }
    }
    DisposableEffect(player, activity) {
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        onDispose {
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            player.release()
        }
    }
    Box(modifier) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { viewContext ->
                PlayerView(viewContext).apply {
                    this.player = player
                    useController = true
                }
            },
        )
    }
}
