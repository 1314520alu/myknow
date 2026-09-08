package com.myknow.app.data.seed

import com.myknow.app.data.SpecJson
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device
import com.myknow.app.data.model.SpecField

/** Official Hobbywing H15 Plus / H15MD Plus reference for field lookup. */
object SeedData {
    private const val T0 = 1_720_000_000_000L
    const val PRODUCT_PAGE = "https://www.hobbywing.com/products/h15-plus-new"
    const val SPEC_PDF = "https://www.hobbywing.com/uploads/file/20260228/a87197efd698c80fd69797af9c3ce88d.pdf"
    const val MANUAL_PDF = "https://www.hobbywing.com/uploads/file/20260320/723c602bafe0eb4c9c582b5bef198b8e.pdf"

    fun devices(): List<Device> = listOf(
        device(
            id = "hobbywing-h15md-plus",
            type = "PROPULSION",
            brand = "好盈 Hobbywing",
            model = "H15MD Plus（原 H15 Plus）",
            tags = "H15 Plus,H15MD,共轴,24S,28S,行业动力",
            datasheetUrl = PRODUCT_PAGE,
            favorite = true,
            time = T0 + 50,
            notes = """
现名 H15MD Plus，原品名 H15 Plus。行业共轴一体动力（电机×2 + 电调×2 + 电机座 + 桨叶）。
料号 HW-SMC819DUL00。

用途：物流、吊运、应急消防等大载重多旋翼。4 轴 8 桨最大起飞重量约 320 kg，适用 150~200 kg 载荷机型。单轴推荐起飞重量 80 kg，最大拉力 195 kg（海平面）。最大拉力只作机动/抗风冗余，禁止当额定载荷用。

电压：额定 24S-92V / 28S-108V，输入 36~130 V，适配 24S~28S LiPo。100V 高压平台，最高 28S。
功率：额定输入 10600 W，额定输出 9300 W。推荐拉力力效 7.5 g/W。
重量：14550±200 g（含线、不含桨，以技术参数 PDF / 说明书为准）。
碳管：外径 80 mm、壁厚 5 mm；电机座 3° 倾角。防护 IPX6，环境 -40~60 ℃。

电源线 7AWG 2500±50 mm（红正黑负）。信号线 2700±50 mm。
线序：黑-GND，白-PWM；黄-GND，灰-CH（CAN High），绿-CL（CAN Low）。
调参盒：DataLinkBox G3。油门 PWM+CAN，PWM 脉宽 1100-1940 μs。CAN 出厂 HWCAN，可选 DroneCAN。无终端电阻，默认 500 kbps。

配套桨：直桨 MSC 73x21 / 折叠桨 MFC 73x23。必须用原厂配套桨。

技术参数 PDF
$SPEC_PDF

说明书 PDF
$MANUAL_PDF
            """.trimIndent(),
            specs = listOf(
                SpecField("产品型号", "H15MD Plus-24S"),
                SpecField("原品名", "H15 Plus"),
                SpecField("料号", "HW-SMC819DUL00"),
                SpecField("最大拉力", "195", "kg"),
                SpecField("单轴推荐拉力", "80", "kg"),
                SpecField("推荐力效", "7.5", "g/W"),
                SpecField("适配电池", "24S~28S LiPo"),
                SpecField("额定电压", "24S-92V / 28S-108V"),
                SpecField("电压范围", "36~130", "V"),
                SpecField("额定输入功率", "10600", "W"),
                SpecField("额定输出功率", "9300", "W"),
                SpecField("碳管", "Ø80 mm / 壁厚 5 mm"),
                SpecField("防护等级", "IPX6"),
                SpecField("工作温度", "-40~60", "℃"),
                SpecField("重量(含线不含桨)", "14550±200", "g"),
                SpecField("电源线", "7AWG 2500±50 mm"),
                SpecField("信号线", "2700±50 mm"),
                SpecField("油门", "PWM + CAN"),
                SpecField("调参盒", "DataLinkBox G3"),
                SpecField("推荐桨叶", "MSC 73x21 / MFC 73x23"),
                SpecField("产品页", PRODUCT_PAGE),
                SpecField("技术参数PDF", SPEC_PDF),
                SpecField("说明书PDF", MANUAL_PDF),
            ),
        ),
        device(
            id = "hobbywing-h15md-plus-esc",
            type = "ESC",
            brand = "好盈 Hobbywing",
            model = "H15MD Plus 电调",
            tags = "H15 Plus,FOC,UAVCAN,110A",
            datasheetUrl = SPEC_PDF,
            favorite = true,
            time = T0 + 40,
            notes = """
H15MD Plus 套装内 FOC 电调。自研算法，数字+模拟双油门冗余。

持续 110 A（非密闭、环境约 ≤35/40℃），瞬时 300 A / 3 s。
尺寸 156×83.6×54.5 mm，重量（不含线）616±5 g。
额定电压 24S-92V / 28S-108V，电压范围 36~130 V。

PWM：脉宽 1100~1940 μs，频率 50~500 Hz，电平 5V/3.3V。油门行程出厂固化，不支持校准，软件可改范围。
CAN：Cyphal/UAVCAN，出厂 HWCAN，可选 DroneCAN。无终端电阻。采样点 83.3%，默认 500 kbps。
黑匣子：故障+日志，默认 2 h，最长 48 h。

无低压保护、无过温停转。过温只告警：MOS>110℃ 或电容>100℃ 会闪灯并上报，不停转。
过流阈值约 800 A / 4 μs。油门丢失 >30 ms 保持末值并报警，>1 s 关输出。
首次启动约 3 s 延时，飞控需匹配 MOT_SPOOL_TIME / TKOFF_SLEW_TIME，否则会弹射起飞。
CAN 数字油门建议飞控怠速 6%。出厂 ID1、通道 1，同机各电调 ID/通道不能重复。
            """.trimIndent(),
            specs = listOf(
                SpecField("额定电压", "24S-92V / 28S-108V"),
                SpecField("电压范围", "36~130", "V"),
                SpecField("持续电流", "110", "A"),
                SpecField("瞬时电流", "300A / 3s"),
                SpecField("通讯", "UAVCAN / Cyphal"),
                SpecField("CAN协议", "HWCAN（默认）/ DroneCAN"),
                SpecField("双油门", "PWM + CAN"),
                SpecField("PWM脉宽", "1100-1940", "μs"),
                SpecField("PWM频率", "50-500", "Hz"),
                SpecField("PWM电平", "5V / 3.3V"),
                SpecField("油门校准", "不支持"),
                SpecField("CAN波特率", "500", "kbps"),
                SpecField("CAN电阻", "无终端电阻"),
                SpecField("故障日志", "2-48", "h"),
                SpecField("尺寸", "156×83.6×54.5", "mm"),
                SpecField("重量(不含线)", "616±5", "g"),
                SpecField("驱动", "FOC"),
            ),
        ),
        device(
            id = "hobbywing-h15md-plus-motor",
            type = "MOTOR",
            brand = "好盈 Hobbywing",
            model = "H15MD Plus 电机 31KV",
            tags = "H15 Plus,31KV,共轴",
            datasheetUrl = SPEC_PDF,
            favorite = false,
            time = T0 + 30,
            notes = """
套装电机，KV 31。外径 167.1 mm，定子 Φ155.6×H35 mm，槽极 36N42P。
重量（含线）4100±100 g。桨叶安装孔深 12 mm。三轴承。标配电机温度监测。加大出风口 + 离心风扇。
电机座适配 Ø80 mm 碳管，3° 倾角。禁止私拆、禁止换非配套桨。
            """.trimIndent(),
            specs = listOf(
                SpecField("KV", "31", "rpm/V"),
                SpecField("电机外径", "167.1", "mm"),
                SpecField("定子", "Φ155.6×H35", "mm"),
                SpecField("槽极", "36N42P"),
                SpecField("重量(含线)", "4100±100", "g"),
                SpecField("桨安装孔深", "12", "mm"),
                SpecField("轴承", "三轴承"),
                SpecField("温度监测", "标配"),
            ),
        ),
        device(
            id = "hobbywing-msc-73x21",
            type = "PROPELLER",
            brand = "好盈 Hobbywing",
            model = "MSC 73x21 直桨",
            tags = "H15 Plus,直桨,73寸",
            datasheetUrl = PRODUCT_PAGE,
            favorite = false,
            time = T0 + 20,
            notes = """
H15MD Plus 原厂直桨。碳纤维复合材料。重量 1300±20 g。
安装：D60-6×M6，中心孔 D20。螺丝 M6×16，锁紧扭矩 8 N·m。
左旋螺母推荐 20 N·m，右旋螺母推荐 30 N·m。
必须使用原厂配套桨，错桨会触发电调保护甚至坠机。
            """.trimIndent(),
            specs = listOf(
                SpecField("型号", "MSC 73x21"),
                SpecField("类型", "直桨"),
                SpecField("材料", "碳纤维复合材料"),
                SpecField("重量", "1300±20", "g"),
                SpecField("安装尺寸", "D60-6×M6，中心孔 D20"),
                SpecField("螺丝", "M6×16 / 8 N·m"),
            ),
        ),
        device(
            id = "hobbywing-mfc-73x23",
            type = "PROPELLER",
            brand = "好盈 Hobbywing",
            model = "MFC 73x23 折叠桨",
            tags = "H15 Plus,折叠桨,73寸",
            datasheetUrl = PRODUCT_PAGE,
            favorite = false,
            time = T0 + 10,
            notes = """
H15MD Plus 原厂折叠桨。碳纤维复合材料。重量 1854.8±32 g。
安装：D46-4×M6，中心孔 D16。螺丝 M6×14，锁紧扭矩 8 N·m。
车载定桨：H15MD 系列默认支持定桨。
            """.trimIndent(),
            specs = listOf(
                SpecField("型号", "MFC 73x23"),
                SpecField("类型", "折叠桨"),
                SpecField("材料", "碳纤维复合材料"),
                SpecField("重量", "1854.8±32", "g"),
                SpecField("安装尺寸", "D46-4×M6，中心孔 D16"),
                SpecField("螺丝", "M6×14 / 8 N·m"),
            ),
        ),
    )

    fun articles(): List<Article> = listOf(
        Article(
            id = "h15-wiring",
            title = "H15 Plus 接线与线序",
            category = "WIRING",
            tags = "H15 Plus,接线,CAN,PWM",
            favorite = true,
            createdAt = T0,
            updatedAt = T0,
            body = """
电源
• 7AWG，红正黑负，长度 2500±50 mm（含插头）
• 出厂已焊好插头。改焊必须用足功率烙铁，焊点可靠

PWM 油门（黑白）
• 黑：GND
• 白：油门 Signal
• 插飞控对应电机口
• 脉宽 1100~1940 μs，频率 50~500 Hz，电平 5V 或 3.3V

CAN（黄灰绿）
• 黄：CAN GND
• 灰：CAN High（CH）
• 绿：CAN Low（CL）
• 用于数字油门、遥测、日志、OTA
• 出厂无终端电阻，按整机拓扑统一匹配
• 默认 500 kbps，采样点 83.3%
• 协议：Cyphal/UAVCAN；出厂 HWCAN，可改 DroneCAN
• 兼容 ArduPilot、PX4、微克、博鹰、博睿等

CAN 数字油门
• 飞控必须能输出 CAN 油门
• 建议怠速油门 6%
• 出厂 ID=1、通道=1；同机各电调 ID 和通道不能重复

数据
实时输出油门、转速、母线电流/电压、电容温度、MOS 温度。
            """.trimIndent(),
        ),
        Article(
            id = "h15-install",
            title = "H15 Plus 安装与碳管",
            category = "WIRING",
            tags = "H15 Plus,安装,碳管",
            favorite = false,
            createdAt = T0,
            updatedAt = T0,
            body = """
套装组成
电机×2、电调×2、桨叶×2、电机座×1、紧固螺钉、LED 灯组。

碳管
• 外径 80 mm，推荐壁厚 5 mm（也支持 3 mm）
• 内衬铝套 + 四向锁固外箍 + 定位凸台
• 碳管端面到电机中心约 8 mm（见说明书尺寸图）
• 电机座 3° 倾角，注意旋向

桨
• 直桨 MSC 73x21：D60-6×M6，中心孔 D20，M6×16 / 8 N·m
• 折叠桨 MFC 73x23：D46-4×M6，中心孔 D16，M6×14 / 8 N·m
• 左旋螺母约 20 N·m，右旋螺母约 30 N·m
• 安装调试先卸桨

禁止
私改共轴结构、换电机/电调、用非配套桨。大地 PE 与强弱电隔离，电机座与电调外壳共地。
            """.trimIndent(),
        ),
        Article(
            id = "h15-protect",
            title = "H15 Plus 保护与告警",
            category = "SAFETY",
            tags = "H15 Plus,保护,告警",
            favorite = true,
            createdAt = T0,
            updatedAt = T0,
            body = """
行业机电调：无低压保护、无过温停转。飞行中必须自己看电压和温度。

上电自检
通过后有自检鸣叫才能转；失败则不驱动并闪灯。

上电电压
低于 36 V 或高于 130 V：闪灯+鸣叫，无法自检。运行中不再做电压保护。低于 36 V 器件会异常，立刻降落。

堵转
尝试重启 3 次，仍堵则关输出。需断电、排除故障后再上电。

过流
瞬间超过约 800 A、持续约 4 μs：关输出并尝试重启。多次失败则断电恢复。

油门丢失
>30 ms：保持最后油门并报警。
>1 s：关输出。信号恢复后恢复功率。

启动延时
第一次启动约 3 s 才能全速。飞控必须加启动斜坡（ArduPilot：MOT_SPOOL_TIME、TKOFF_SLEW_TIME），否则弹射起飞。

过温警告（不停转）
MOS >110℃ 或电容 >100℃：闪灯并上报，不降功率。持续过温会烧毁，减油门或降落。

刹车反电势
收油门反电势限压阈值 132 V。

其它保护
上电低压/高压、MOS 短路、电机缺相、油门未归零、采样偏置异常。
            """.trimIndent(),
        ),
        Article(
            id = "h15-thrust",
            title = "H15 Plus 24S 拉力对照（MSC 73x21）",
            category = "MATCHING",
            tags = "H15 Plus,拉力,24S",
            favorite = true,
            createdAt = T0,
            updatedAt = T0,
            body = """
实验室：25℃、海平面、92V（24S）、MSC 73x21。仅供参考。

油门    拉力      电流     输入功率    力效
33%    22.2 kg   19.3 A    1.77 kW    12.5 g/W
42%    37.6 kg   39.3 A    3.62 kW    10.4 g/W
50%    55.4 kg   68.2 A    6.28 kW     8.8 g/W
54%    65.6 kg   87.1 A    8.02 kW     8.2 g/W
56%    71.0 kg   97.8 A    9.00 kW     7.9 g/W
58%    76.7 kg  109.5 A   10.07 kW     7.6 g/W
60%    82.6 kg  122.1 A   11.24 kW     7.4 g/W
70%   115.5 kg  202.2 A   18.60 kW     6.2 g/W
80%   152.4 kg  311.6 A   28.67 kW     5.3 g/W
100%  195.0 kg  465.8 A   42.86 kW     4.5 g/W

读表
• 单轴推荐 80 kg ≈ 58%~60% 油门，力效约 7.5 g/W
• 195 kg 是海平面最大拉力，只能当机动/抗风余量
• 单轴起飞重量 = 整机起飞重量 ÷ 轴数，不得超过 80 kg
• 电调持续电流标称 110 A，58% 已接近 110 A，再往上是短时能力

28S / 108V 同桨拉力更大、电流也更大，以官网 108V 表为准。
            """.trimIndent(),
        ),
        Article(
            id = "h15-caution",
            title = "H15 Plus 使用注意",
            category = "SAFETY",
            tags = "H15 Plus,安全",
            favorite = false,
            createdAt = T0,
            updatedAt = T0,
            body = """
• 工业非载人配件。远离人群、高压线。遵守当地法规。
• 环境 -40~60℃。大风大雨雪雾雷电沙尘结冰不要飞。
• 必须原厂配套桨。私改结构/换件造成损失厂家不负责。
• 禁止超载：最大拉力 ≠ 额定起飞重量。超载会迅速过热坠机。
• 禁止私拆电机、电调，破坏防护。
• 每次起飞前检查螺钉、电机水平、桨叶完好。
• 降落后面板很烫，不要马上摸。
• 维修只用原厂件。
• 地面测试不要带桨。
            """.trimIndent(),
        ),
    )

    private fun device(
        id: String,
        type: String,
        brand: String,
        model: String,
        tags: String,
        datasheetUrl: String,
        notes: String,
        specs: List<SpecField>,
        favorite: Boolean = false,
        time: Long = T0,
    ) = Device(
        id = id,
        type = type,
        brand = brand,
        model = model,
        specsJson = SpecJson.encode(specs),
        notes = notes,
        tags = tags,
        datasheetUrl = datasheetUrl,
        favorite = favorite,
        createdAt = time,
        updatedAt = time,
    )
}
