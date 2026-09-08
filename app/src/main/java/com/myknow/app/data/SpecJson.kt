package com.myknow.app.data

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.myknow.app.data.model.SpecField

object SpecJson {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    fun encode(fields: List<SpecField>): String = json.encodeToString(fields)

    fun decode(raw: String): List<SpecField> {
        if (raw.isBlank()) return emptyList()
        return runCatching { json.decodeFromString<List<SpecField>>(raw) }.getOrDefault(emptyList())
    }
}

object SpecTemplates {
    fun defaults(typeName: String): List<SpecField> = when (typeName) {
        "PROPULSION" -> listOf(
            SpecField("产品型号", ""),
            SpecField("最大拉力", "", "kg"),
            SpecField("单轴推荐拉力", "", "kg"),
            SpecField("推荐力效", "", "g/W"),
            SpecField("适配电池", ""),
            SpecField("额定电压", ""),
            SpecField("电压范围", "", "V"),
            SpecField("防护等级", ""),
            SpecField("重量", "", "g"),
        )
        "MOTOR" -> listOf(
            SpecField("KV", "", "rpm/V"),
            SpecField("最大电流", "", "A"),
            SpecField("最大功率", "", "W"),
            SpecField("电压范围", "", "S"),
            SpecField("定子规格", ""),
            SpecField("轴径", "", "mm"),
            SpecField("重量", "", "g"),
            SpecField("推荐桨叶", ""),
            SpecField("槽极", ""),
        )
        "ESC" -> listOf(
            SpecField("持续电流", "", "A"),
            SpecField("爆发电流", "", "A"),
            SpecField("电压", "", "S"),
            SpecField("协议", ""),
            SpecField("固件", ""),
            SpecField("BEC", ""),
            SpecField("重量", "", "g"),
            SpecField("尺寸", "", "mm"),
            SpecField("接口", ""),
        )
        "FLIGHT_CONTROLLER" -> listOf(
            SpecField("MCU", ""),
            SpecField("陀螺仪", ""),
            SpecField("固件", ""),
            SpecField("UART", "", "路"),
            SpecField("安装孔距", "", "mm"),
            SpecField("OSD", ""),
            SpecField("气压计", ""),
            SpecField("黑匣子", ""),
            SpecField("输入电压", ""),
        )
        "BATTERY" -> listOf(
            SpecField("电压", "", "S"),
            SpecField("容量", "", "mAh"),
            SpecField("C数", "", "C"),
            SpecField("插头", ""),
            SpecField("重量", "", "g"),
            SpecField("尺寸", "", "mm"),
            SpecField("放电电流", "", "A"),
        )
        "FRAME" -> listOf(
            SpecField("轴距", "", "mm"),
            SpecField("材料", ""),
            SpecField("臂厚", "", "mm"),
            SpecField("适用桨叶", "", "inch"),
            SpecField("重量", "", "g"),
            SpecField("堆叠安装", "", "mm"),
        )
        "PROPELLER" -> listOf(
            SpecField("尺寸", "", "inch"),
            SpecField("螺距", ""),
            SpecField("叶数", ""),
            SpecField("材料", ""),
            SpecField("轴孔", "", "mm"),
            SpecField("重量", "", "g"),
        )
        "VTX" -> listOf(
            SpecField("功率", "", "mW"),
            SpecField("频段", ""),
            SpecField("协议", ""),
            SpecField("输入电压", ""),
            SpecField("接口", ""),
            SpecField("重量", "", "g"),
        )
        "CAMERA" -> listOf(
            SpecField("传感器", ""),
            SpecField("镜头", ""),
            SpecField("制式", ""),
            SpecField("电压", ""),
            SpecField("尺寸", "", "mm"),
            SpecField("重量", "", "g"),
        )
        "GPS" -> listOf(
            SpecField("模组", ""),
            SpecField("协议", ""),
            SpecField("罗盘", ""),
            SpecField("更新率", "", "Hz"),
            SpecField("电压", ""),
            SpecField("重量", "", "g"),
        )
        else -> listOf(
            SpecField("规格", ""),
            SpecField("电压", ""),
            SpecField("重量", "", "g"),
            SpecField("接口", ""),
        )
    }

    fun specValue(fields: List<SpecField>, key: String): String =
        fields.firstOrNull { it.key == key }?.value.orEmpty()
}
