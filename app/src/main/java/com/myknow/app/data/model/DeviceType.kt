package com.myknow.app.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BatteryChargingFull
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.CellTower
import androidx.compose.material.icons.outlined.DeveloperBoard
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.material.icons.outlined.PrecisionManufacturing
import androidx.compose.material.icons.outlined.SettingsInputComponent
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material.icons.outlined.Toys
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material.icons.outlined.ViewInAr
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class DeviceType(
    val label: String,
    val shortLabel: String,
    val icon: ImageVector,
    val accent: Color,
) {
    PROPULSION("动力套", "动力套", Icons.Outlined.PrecisionManufacturing, Color(0xFFE8A838)),
    MOTOR("电机", "电机", Icons.Outlined.Toys, Color(0xFFE8A838)),
    ESC("电调", "电调", Icons.Outlined.Speed, Color(0xFF4ECDC4)),
    FLIGHT_CONTROLLER("飞控", "飞控", Icons.Outlined.Memory, Color(0xFF5B8CFF)),
    BATTERY("电池", "电池", Icons.Outlined.BatteryChargingFull, Color(0xFF7DDA58)),
    FRAME("机架", "机架", Icons.Outlined.ViewInAr, Color(0xFF9AA4B2)),
    PROPELLER("螺旋桨", "桨叶", Icons.Outlined.SettingsInputComponent, Color(0xFFC084FC)),
    VTX("图传", "图传", Icons.Outlined.Videocam, Color(0xFFFF8A4C)),
    CAMERA("摄像头", "镜头", Icons.Outlined.CameraAlt, Color(0xFFFF6B9D)),
    GPS("定位模组", "GPS", Icons.Outlined.CellTower, Color(0xFF2DD4BF)),
    OTHER("其他器件", "其他", Icons.Outlined.DeveloperBoard, Color(0xFF94A3B8)),
    ;

    companion object {
        fun fromName(raw: String): DeviceType =
            entries.firstOrNull { it.name == raw } ?: OTHER
    }
}

enum class ArticleCategory(val label: String) {
    PROTOCOL("协议与固件"),
    MATCHING("选型匹配"),
    WIRING("接线与安装"),
    TUNING("调试与参数"),
    SAFETY("安全与维护"),
    OTHER("其他"),
}
