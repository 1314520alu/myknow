package com.myknow.app.data.model

data class VideoSource(
    val id: String,
    val name: String,
    val brand: String,
    val rtspUrl: String,
    val ip: String,
    val note: String,
) {
    companion object {
        val catalog: List<VideoSource> = listOf(
            VideoSource(
                id = "siyi-zr10-main",
                name = "SIYI ZR10 主码流",
                brand = "思翼 SIYI",
                rtspUrl = "rtsp://192.168.144.25:8554/main.264",
                ip = "192.168.144.25",
                note = "ZR10 默认视频源。手机和吊舱要在同一网段（常见 192.168.144.x）。无图先 ping 该 IP。",
            ),
            VideoSource(
                id = "siyi-zr10-cam2",
                name = "SIYI ZR10 相机2",
                brand = "思翼 SIYI",
                rtspUrl = "rtsp://192.168.144.26:8554/main.264",
                ip = "192.168.144.26",
                note = "双吊舱时第二路 ZR10，对应 SIYI FPV 里的 Camera 2。",
            ),
        )

        fun byId(id: String): VideoSource? = catalog.firstOrNull { it.id == id }
    }
}
