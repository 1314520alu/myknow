package com.myknow.app.data.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class VideoSourceTest {
    @Test
    fun zr10IsDefaultVideoSource() {
        val zr10 = VideoSource.catalog.first { it.id == "siyi-zr10-main" }
        assertTrue(zr10.name.contains("ZR10"))
        assertEquals("rtsp://192.168.144.25:8554/main.264", zr10.rtspUrl)
        assertEquals("192.168.144.25", zr10.ip)
    }
}
