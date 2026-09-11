package com.myknow.app.data.seed

import com.myknow.app.data.SpecJson
import com.myknow.app.data.model.Article
import com.myknow.app.data.model.Device
import com.myknow.app.data.model.SpecField

/** Official Hobbywing, SIYI, Skydroid, Unicore, u-blox, CUAV and Benewake field-lookup seed. */
object SeedData {
    private const val T0 = 1_720_000_000_000L
    const val PRODUCT_PAGE = "https://www.hobbywing.com/products/h15-plus-new"
    const val SPEC_PDF = "https://www.hobbywing.com/uploads/file/20260228/a87197efd698c80fd69797af9c3ce88d.pdf"
    const val MANUAL_PDF = "https://www.hobbywing.com/uploads/file/20260320/723c602bafe0eb4c9c582b5bef198b8e.pdf"
    const val H13_PRODUCT_PAGE = "https://www.hobbywing.com/products/h13a"
    const val H13_PRODUCT_PAGE_EN = "https://www.hobbywing.com/en/products/h13-1"
    const val H13_NEWS = "https://www.hobbywing.com/news/info/103"
    const val H13_SPEC_PDF = "https://www.hobbywing.com/uploads/file/20260309/33612d30c3835d5a4e4e2f36884d6e32.pdf"
    const val H13_MANUAL_PDF = "https://www.hobbywing.com/en/uploads/file/20250828/680e2e2e8798f49de283d412ff1c6cf6.pdf"
    const val SIYI_A8 = "https://siyi.biz/zh/product/tri-axis-single-camera-gimbal/a8-mini/"
    const val SIYI_A8_SPEC = "https://siyi.biz/zh/product/tri-axis-single-camera-gimbal/a8-mini/spec/"
    const val SIYI_A8_MANUAL = "https://siyi.biz/siyi_file/A8%20mini/A8%20mini%20User%20Manual%20v1.9.pdf"
    const val SIYI_ZR10 = "https://siyi.biz/zh/product/tri-axis-single-camera-gimbal/zr10/"
    const val SIYI_ZR10_SPEC = "https://siyi.biz/zh/product/tri-axis-single-camera-gimbal/zr10/spec/"
    const val SIYI_UNIRC7 = "https://siyi.biz/zh/product/hand-gcs/uni-rc7/spec/"
    const val SIYI_UNIRC7_EN = "https://siyi.biz/en/product/hand-gcs/uni-rc7/"
    const val SIYI_UNIRC10 = "https://siyi.biz/product/hand-gcs/uni-rc-10-pro"
    const val SIYI_UNIRC10_SPEC = "https://www.siyi.biz/index.php?asd=1131&id=specs1"
    const val SIYI_MT11 = "https://siyi.biz/en/index.php?id=1058"
    const val SIYI_MT11_ZH = "https://www.siyi.biz/product/tri-axis-multi-sensor-gimbal-pod/uni-pod-mt-11"
    const val SKYDROID_SITE = "https://www.skydroid.xin/"
    const val SKYDROID_G16_MANUAL = "https://www.worldronemarket.com/skydroid-g16-user-manual/"
    const val SKYDROID_G20 = "https://skydroidglobal.com/products/skydroid-g20-remote-controller"
    const val SKYDROID_H16_MANUAL = "https://manual.cuav.net/h16/H16-users-manual.pdf"
    const val SKYDROID_H30_MANUAL = "https://www.worldronemarket.com/skydroid-h30-r30/"
    const val UNICORE_UM982 = "https://www.unicore.com/products/detail/26"
    const val UNICORE_UM982_MANUAL = "https://www.unicore.com/assets/upload/file/UM982_User_Manual_CH_R1_11.pdf"
    const val UNICORE_UM982_BRIEF = "https://unicore.com/assets/upload/file/UM982_Product_Brief_Ch_mail.pdf"
    const val UBLOX_F9P = "https://www.u-blox.com/en/product/zed-f9p-module"
    const val UBLOX_F9P_DS = "https://content.u-blox.com/sites/default/files/documents/ZED-F9P-02B_DataSheet_UBX-21023276.pdf"
    const val UBLOX_F9P_SUM = "https://content.u-blox.com/sites/default/files/ZED-F9P_ProductSummary_UBX-17005151.pdf"
    const val H150_PRODUCT = "https://www.hobbywing.com/products/xrotor-h150a-24s-foc-v1125"
    const val H150_PRODUCT_EN = "https://www.hobbywing.com/en/products/xrotor-h150a-24s-foc-v1125"
    const val H150_MANUAL = "https://www.hobbywing.com/uploads/file/20250401/e3e501530ee8aaf7f89f7fa32ab60f5c.pdf"
    const val H150_SPEC_DWG = "https://www.hobbywing.com/uploads/file/20230303/8043453da07d3933b05ed30d0ef2b48c.PDF"
    const val H150_14S = "https://www.hobbywing.com/en/products/xrotorh150a14sfoc"
    const val CUAV_SITE = "https://www.cuav.net"
    const val CUAV_X7_SERIES = "https://doc.cuav.net/controller/x7/zh-hans/"
    const val CUAV_X7_PLUS = "https://doc.cuav.net/controller/x7/zh-hans/x7-plus.html"
    const val CUAV_X7_PRO = "https://doc.cuav.net/controller/x7/zh-hans/x7-pro.html"
    const val CUAV_X7_AP = "https://ardupilot.org/copter/docs/common-cuav-x7-family-overview.html"
    const val CUAV_V6X = "https://doc.cuav.net/controller/pixhawk-v6x/en/"
    const val CUAV_V6X_V1 = "https://doc.cuav.net/controller/pixhawk-v6x/en/pixhawk-v6x.html"
    const val CUAV_V6X_PX4 = "https://docs.px4.io/main/en/flight_controller/cuav_pixhawk_v6x.html"
    const val BENEWAKE = "https://www.benewake.com"
    const val BENEWAKE_EN = "https://en.benewake.com"
    const val TF02_PRO = "https://en.benewake.com/TF02Pro/index.html"
    const val TF02_PRO_ZH = "https://benewake.com/TF02Pro/index.html"
    const val TF02_PRO_MANUAL = "https://en.benewake.com/uploadfiles/2025/04/20250430175509935.pdf"
    const val TF02_PRO_I2C_AP = "https://en.benewake.com/uploadfiles/2025/04/20250402114717107.pdf"
    const val TF03 = "https://en.benewake.com/TF03/index.html"
    const val TF03_ZH = "https://benewake.com/TF03/index.html"
    const val TF03_MANUAL = "https://en.benewake.com/uploadfiles/2024/04/20240426134845102.pdf"
    const val TF03_SPEC = "https://en.benewake.com/uploadfiles/2023/05/20230505181408289.pdf"
    const val BENEWAKE_AP = "https://ardupilot.org/copter/docs/common-benewake-tf02-lidar.html"

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
        device(
            id = "hobbywing-h13md",
            type = "PROPULSION",
            brand = "好盈 Hobbywing",
            model = "H13MD 共轴一体动力",
            tags = "H13,H13MD,共轴,24S,28S,行业动力",
            datasheetUrl = H13_PRODUCT_PAGE,
            favorite = true,
            time = T0 + 150,
            notes = """
行业共轴一体动力（电机×2 + 电调×2 + 电机座 + 桨叶）。料号 HW-SMC809DUL00。电机 13825-37KV，电调 H150A FOC。

用途：物资吊运、物流运输、消防灭火、应急救援等重载多旋翼。4 轴 8 桨推荐起飞重量约 180 kg，任务载荷可达约 100 kg。单轴推荐拉力 45 kg。最大拉力 110 kg（MSC 54x20）/ 113 kg（MSC 57x20），海平面实验室数据。最大拉力只作机动/抗风冗余，禁止当额定载荷用。

电压：额定 24S-92V / 28S-108V，输入 30~130 V，适配 24S~28S LiPo。100V 高压平台，最高 28S。官网称相对 24S 电流约降 15%。
功率：MSC 54x20 额定输入 6500 W、额定输出（最大持续）5720 W；MSC 57x20 额定输出 5544 W。推荐拉力力效 6.8 g/W（54x20）/ 7.2 g/W（57x20）。
重量（含线、桨）：7890±100 g（54x20）/ 8010±100 g（57x20）。
碳管：外径 60 mm、壁厚约 2.5 mm（内衬约 Φ55）；电机座 3° 倾角。防护 IP35，环境 -40~65 ℃。

电源线 12AWG 1440±20 mm（红正黑负，硅胶线）。信号线 1640±20 mm。
PWM（黑白）：黑-GND，白-油门。CAN（红灰）：红-CH，灰-CL。
调参盒：DataLinkBox G3。油门 PWM+CAN，PWM 脉宽 1100-1940 μs，频率 50~500 Hz。油门行程不支持校准。通讯 UAVCAN，支持 DroneCAN。出厂 ID1、通道 1，总线 500 kbps。同机各电调 ID/通道不能重复。

配套桨：碳纤维直桨 MSC 54x20 / MSC 57x20。必须用原厂配套桨，FOC 程序与电机+桨组合绑定。可定制延长线、倾角转接座、电机温度监测、锁桨，以及碳纤折叠桨（规格见官网）。

推荐整机配置（官网）：起飞 180 kg，额定拉力 45 kg，载荷约 100 kg，续航 20 min+，电池 24S 70000mAh×2。

产品页
$H13_PRODUCT_PAGE

英文产品页
$H13_PRODUCT_PAGE_EN

发布说明
$H13_NEWS

技术参数 PDF
$H13_SPEC_PDF

说明书 PDF（H13-13825）
$H13_MANUAL_PDF
            """.trimIndent(),
            specs = listOf(
                SpecField("产品型号", "H13MD MSC 54x20 / MSC 57x20"),
                SpecField("料号", "HW-SMC809DUL00"),
                SpecField("最大拉力", "110 / 113", "kg"),
                SpecField("单轴推荐拉力", "45", "kg"),
                SpecField("推荐力效", "6.8 / 7.2", "g/W"),
                SpecField("适配电池", "24S~28S LiPo"),
                SpecField("额定电压", "24S-92V / 28S-108V"),
                SpecField("电压范围", "30~130", "V"),
                SpecField("额定输入功率", "6500（54x20）", "W"),
                SpecField("额定输出功率", "5720 / 5544", "W"),
                SpecField("碳管", "Ø60 mm / 壁厚约 2.5 mm"),
                SpecField("防护等级", "IP35"),
                SpecField("工作温度", "-40~65", "℃"),
                SpecField("重量(含线、桨)", "7890±100 / 8010±100", "g"),
                SpecField("电源线", "12AWG 1440±20 mm"),
                SpecField("信号线", "1640±20 mm"),
                SpecField("油门", "PWM + CAN"),
                SpecField("调参盒", "DataLinkBox G3"),
                SpecField("推荐桨叶", "MSC 54x20 / MSC 57x20"),
                SpecField("产品页", H13_PRODUCT_PAGE),
                SpecField("技术参数PDF", H13_SPEC_PDF),
                SpecField("说明书PDF", H13_MANUAL_PDF),
            ),
        ),
        device(
            id = "hobbywing-h13md-esc",
            type = "ESC",
            brand = "好盈 Hobbywing",
            model = "H13MD 电调 H150A FOC",
            tags = "H13,H13MD,FOC,UAVCAN,H150A,60A",
            datasheetUrl = H13_SPEC_PDF,
            favorite = false,
            time = T0 + 140,
            notes = """
H13MD 套装内 H150A FOC 电调，不是零售货架上的 XRotor Pro H150A 24S FOC。独立可搜器件见「XRotor Pro H150A 24S FOC」。数字+模拟双油门冗余。通讯 UAVCAN。

持续 60 A（非密闭、环境约 ≤60℃），瞬时 150 A / 3 s（散热良好）。
尺寸 132.5×67.5×37.4 mm（带插头），重量（不含线）395 g。
电压范围 30~130 V，额定 24S-92V / 28S-108V。

PWM：脉宽 1100~1940 μs，频率 50~500 Hz。油门行程出厂固化，不支持校准。
CAN：UAVCAN，支持 DroneCAN。出厂 ID1、通道 1，总线 500 kbps。同机各电调 ID/通道不能重复。
黑匣子：故障存储，可用 DataLinkBox G3 读故障。

无低压保护、无过温停转（H13-13825 说明书）。过温只告警：MOS>110℃ 或电容>100℃ 经数据口上报，减油门或降落。
过流：瞬间相电流异常达 360 A 关输出并尝试重启；仍失败则断电再上电。
油门丢失：立即关输出；信号恢复后立刻恢复。
上电低于 30 V 或高于 130 V：无法自检启动。运行中低于 30 V 器件会异常，立刻降落。
转向出厂已设定，看电机转向标记；封装工艺不支持对调相线改转向。
            """.trimIndent(),
            specs = listOf(
                SpecField("产品型号", "H150A FOC"),
                SpecField("额定电压", "24S-92V / 28S-108V"),
                SpecField("电压范围", "30~130", "V"),
                SpecField("持续电流", "60", "A"),
                SpecField("瞬时电流", "150A / 3s"),
                SpecField("通讯", "UAVCAN"),
                SpecField("CAN协议", "UAVCAN / DroneCAN"),
                SpecField("双油门", "PWM + CAN"),
                SpecField("PWM脉宽", "1100-1940", "μs"),
                SpecField("PWM频率", "50-500", "Hz"),
                SpecField("油门校准", "不支持"),
                SpecField("CAN波特率", "500", "kbps"),
                SpecField("故障存储", "支持"),
                SpecField("尺寸(带插头)", "132.5×67.5×37.4", "mm"),
                SpecField("重量(不含线)", "395", "g"),
                SpecField("驱动", "FOC"),
            ),
        ),
        device(
            id = "hobbywing-h13md-motor",
            type = "MOTOR",
            brand = "好盈 Hobbywing",
            model = "H13MD 电机 13825-37KV",
            tags = "H13,H13MD,37KV,13825,共轴",
            datasheetUrl = H13_SPEC_PDF,
            favorite = false,
            time = T0 + 130,
            notes = """
套装电机 13825-37KV。外径 147.9 mm，槽极 36N42P。
重量（含线）2450±50 g。电机座适配 Ø60 mm 碳管，3° 倾角。
高强度铝合金电机座。电机温度监测为可选项，见官网定制。
禁止私拆、禁止换非配套桨。转向看出厂标记，不要对调相线。
            """.trimIndent(),
            specs = listOf(
                SpecField("型号", "13825-37KV"),
                SpecField("KV", "37", "rpm/V"),
                SpecField("电机外径", "147.9", "mm"),
                SpecField("槽极", "36N42P"),
                SpecField("重量(含线)", "2450±50", "g"),
                SpecField("适配碳管", "Ø60", "mm"),
                SpecField("倾角", "3", "°"),
            ),
        ),
        device(
            id = "hobbywing-msc-54x20",
            type = "PROPELLER",
            brand = "好盈 Hobbywing",
            model = "MSC 54x20 直桨",
            tags = "H13,H13MD,直桨,54寸",
            datasheetUrl = H13_PRODUCT_PAGE,
            favorite = false,
            time = T0 + 120,
            notes = """
H13MD 原厂碳纤维直桨。重量 420±15 g。
安装：D40-4×M5，中心孔 D15。快拆桨座兼容 54x20 与 57x20 孔位。
薄螺母（左旋）15 N·m，厚螺母（右旋）25 N·m，官网写不需要螺丝胶。
必须使用原厂配套桨，错桨会触发电调保护甚至坠机。
            """.trimIndent(),
            specs = listOf(
                SpecField("型号", "MSC 54x20"),
                SpecField("类型", "直桨"),
                SpecField("材料", "碳纤维直桨"),
                SpecField("重量", "420±15", "g"),
                SpecField("安装尺寸", "D40-4×M5，中心孔 D15"),
                SpecField("锁紧扭矩", "左旋 15 / 右旋 25", "N·m"),
            ),
        ),
        device(
            id = "hobbywing-msc-57x20",
            type = "PROPELLER",
            brand = "好盈 Hobbywing",
            model = "MSC 57x20 直桨",
            tags = "H13,H13MD,直桨,57寸",
            datasheetUrl = H13_PRODUCT_PAGE,
            favorite = false,
            time = T0 + 110,
            notes = """
H13MD 原厂碳纤维直桨。重量 480±15 g。
安装：D40-4×M5，中心孔 D15。快拆桨座兼容 54x20 与 57x20 孔位。
薄螺母（左旋）15 N·m，厚螺母（右旋）25 N·m，官网写不需要螺丝胶。
必须使用原厂配套桨，错桨会触发电调保护甚至坠机。
            """.trimIndent(),
            specs = listOf(
                SpecField("型号", "MSC 57x20"),
                SpecField("类型", "直桨"),
                SpecField("材料", "碳纤维直桨"),
                SpecField("重量", "480±15", "g"),
                SpecField("安装尺寸", "D40-4×M5，中心孔 D15"),
                SpecField("锁紧扭矩", "左旋 15 / 右旋 25", "N·m"),
            ),
        ),
        device(
            id = "siyi-a8-mini",
            type = "CAMERA",
            brand = "思翼 SIYI",
            model = "A8 mini 4K 云台",
            tags = "SIYI,思翼,A8 mini,A8,云台,4K",
            datasheetUrl = SIYI_A8_SPEC,
            favorite = true,
            time = T0 + 250,
            notes = """
4K AI 智能跟踪三轴云台（AI 跟踪模块选配）。索尼 1/1.7" CMOS，800 万像素，等效焦距 21 mm，F2.8。六倍数码变焦（说明书：4K 模式不支持变焦；2K 最高约 3.5×，1080p 约 5.5×，720p 约 6×）。FOV 对角 93°、水平 81°。星光夜视、HDR。

视频：以太网、Micro-HDMI、CVBS(AV)。控制输入：S.Bus、UART、网口 UDP/TCP。控制输出：S.Bus。兼容 ArduPilot / PX4（Mavlink）。机头模式、倒立模式；跟随 / FPV / 锁定。

电压：现行规格 11~25.2 V（3S~6S）。2023 年 6 月前早期批次可能不支持 25.2 V / 6S，通电前确认。平均约 5 W，峰值 12 W。尺寸 55×55×70 mm，约 95 g。IP4X。环境 -10~50℃。

云台：抖动量 ±0.01°。中文规格页俯仰 -90°~+25°、航向 -160°~+160°、横滚 -30°~+30°。英文规格页俯仰写 -135°~+45°。产品页写航向轴 270° 旋转范围。以官网最新规格页为准。

TF 卡录像：中文页 4K 3840×2160@25fps；英文页另写 4096×2160@25fps。MicroSD Class10，最大 256 GB。

产品页 $SIYI_A8
规格 $SIYI_A8_SPEC
说明书 $SIYI_A8_MANUAL
            """.trimIndent(),
            specs = listOf(
                SpecField("传感器", "索尼 1/1.7\" CMOS 8MP"),
                SpecField("变焦", "6× 数码"),
                SpecField("焦距/光圈", "21 mm / F2.8"),
                SpecField("FOV", "对角 93° / 水平 81°"),
                SpecField("录像", "4K@25 / 2K / 1080p / 720p"),
                SpecField("视频接口", "以太网 / Micro-HDMI / CVBS"),
                SpecField("控制", "S.Bus / UART / UDP"),
                SpecField("电压", "11~25.2（早期或仅 16.8）", "V"),
                SpecField("功耗", "平均 5 / 峰值 12", "W"),
                SpecField("防护", "IP4X"),
                SpecField("尺寸", "55×55×70", "mm"),
                SpecField("重量", "95", "g"),
                SpecField("温度", "-10~50", "℃"),
            ),
        ),
        device(
            id = "siyi-zr10",
            type = "CAMERA",
            brand = "思翼 SIYI",
            model = "ZR10 2K 变焦吊舱",
            tags = "SIYI,思翼,ZR10,AR10,云台,变焦",
            datasheetUrl = SIYI_ZR10_SPEC,
            favorite = false,
            time = T0 + 240,
            notes = """
用户提到 AR10：思翼官网目录无 AR10，对应型号为 ZR10（SDK 产品 ID 0x6B）。搜索标签含 AR10 / ZR10。

2K / 400 万像素 1/2.7" CMOS。10 倍光学变焦、30 倍混合变焦。F1.8~2.5。星光夜视、HDR。倒立模式；跟随 / FPV / 锁定。可选 AI 跟踪模块。兼容 ArduPilot / PX4（Mavlink）。产品页写航向轴 320° 旋转范围。

视频输出：以太网。控制：S.Bus、UART、UDP（英文页另写 TCP）。电压 11~25.2 V（3S~6S）。英文规格页：2023 年 6 月前早期批次可能是 11~16.5 V。平均 4 W，峰值 12 W。尺寸 121×101×78 mm，381 g。-10~50℃。

云台中文规格：俯仰 -90°~+25°，航向 -160°~+160°，横滚 -30°~+30°，抖动量 ±0.01°。英文规格俯仰写 -135°~+45°，FOV 数字也不同。中文页 1× FOV 对角 69.5° / 水平 61.5°，10× 对角 7.95° / 水平 7°。TF 2K 2560×1440@30fps。存储卡中文页最大 256 GB，英文页写 32 GB。以中文规格页 + 官网最新页为准。

产品页 $SIYI_ZR10
规格 $SIYI_ZR10_SPEC
            """.trimIndent(),
            specs = listOf(
                SpecField("传感器", "1/2.7\" CMOS 4MP"),
                SpecField("变焦", "10× 光学 / 30× 混合"),
                SpecField("光圈", "F1.8~2.5"),
                SpecField("录像", "2K 2560×1440@30fps"),
                SpecField("视频接口", "以太网"),
                SpecField("控制", "S.Bus / UART / UDP"),
                SpecField("电压", "11~25.2", "V"),
                SpecField("功耗", "平均 4 / 峰值 12", "W"),
                SpecField("尺寸", "121×101×78", "mm"),
                SpecField("重量", "381", "g"),
                SpecField("温度", "-10~50", "℃"),
            ),
        ),
        device(
            id = "siyi-unirc-7",
            type = "OTHER",
            brand = "思翼 SIYI",
            model = "UniRC 7 / 7 Pro 手持地面站",
            tags = "SIYI,思翼,UniRC7,UniRC 7,UniRC 7 Pro,地面站",
            datasheetUrl = SIYI_UNIRC7,
            favorite = false,
            time = T0 + 230,
            notes = """
7 英寸手持 GCS。2.4 / 5 GHz（Pro 双频；标准版规格页只列 2.4 GHz）。海面约 30~40 km，郊区约 10~15 km，植保低空约 3~6 km（官网工况表）。单路 4K@30 或双路 1080p@60，码率最高约 65 Mbps，延时低至约 170 ms，AES。Android 13，4 GB + 64 GB。小摇杆、6 个飞行模式按键。IP54。PD 30 W，电池 13400 mAh。充电约 4.5 h。

屏幕：Pro 1920×1200；标准 1280×800。亮度 1600 nit。续航：Pro 约 8 h，标准约 11 h。重量：Pro 1460 g，标准 1440 g。尺寸 274×190×100 mm。

地面接口：Type-C、SIM、TF。HDMI、网口仅 Pro。天空端：16 通道 S.Bus + 5 通道 PWM，双 UART、双网口，XT30 供电 12~76 V。天空端重量：Pro 115 g / 标准约 90 g（不含天线）。

产品页 $SIYI_UNIRC7_EN
规格 $SIYI_UNIRC7
            """.trimIndent(),
            specs = listOf(
                SpecField("屏幕", "7 寸 / Pro 1920×1200 / 标准 1280×800"),
                SpecField("亮度", "1600", "nit"),
                SpecField("系统", "Android 13 / 4+64 GB"),
                SpecField("频段", "2.4 GHz；Pro 另有 5 GHz"),
                SpecField("距离", "海面约 30~40", "km"),
                SpecField("电池", "13400 mAh / Pro≈8h / 标准≈11h"),
                SpecField("防护", "IP54"),
                SpecField("重量", "1460 / 1440", "g"),
                SpecField("天空端供电", "12~76", "V"),
            ),
        ),
        device(
            id = "siyi-unirc-10-pro",
            type = "OTHER",
            brand = "思翼 SIYI",
            model = "UniRC 10 Pro 手持地面站",
            tags = "SIYI,思翼,UniRC10,UniRC 10,UniRC 10 Pro,地面站",
            datasheetUrl = SIYI_UNIRC10_SPEC,
            favorite = false,
            time = T0 + 220,
            notes = """
10.1 英寸三频冗余手持 GCS（2.4 / 5 / X GHz，其他频段需整机认证）。规格页：郊区约 20~25 km，海面约 35~45 km。商店页写 45 km 级。4K 图传、AES、Android 13、4 GB + 64 GB（可 TF 扩展）。IP54。约 27 个物理通道。霍尔摇杆。双操作手 / SDK。

屏幕 1920×1200，2000 nit，60 fps。尺寸 328.2×222.5×101.5 mm。重量 2600 g（说明书写含腹托）。
电池：内置 6700 mAh + 外置 13400 mAh，外置可热插拔，双电约 5 h。系统功耗约 34 W。快充最高 65 W。

接口：HDMI、RJ45、USB-A、Type-C、SIM、TF、UART×2、UDP、蓝牙、3.5 mm 音频。
天空端：16 通道 S.Bus + 5 通道 PWM，双 UART、双网口、CAN。XT30，3S~18S。尺寸约 85×42.4×26.9 mm，200±5 g（不含天线）。

产品页 $SIYI_UNIRC10
规格 $SIYI_UNIRC10_SPEC
            """.trimIndent(),
            specs = listOf(
                SpecField("屏幕", "10.1 寸 1920×1200 / 2000 nit"),
                SpecField("系统", "Android 13 / 4+64 GB"),
                SpecField("频段", "2.4 / 5 / X GHz 三频"),
                SpecField("距离", "海面约 35~45", "km"),
                SpecField("电池", "内 6700 + 外 13400 mAh / 约 5h"),
                SpecField("防护", "IP54"),
                SpecField("尺寸", "328.2×222.5×101.5", "mm"),
                SpecField("重量(含腹托)", "2600", "g"),
                SpecField("天空端供电", "3S~18S"),
            ),
        ),
        device(
            id = "siyi-unipod-mt11",
            type = "CAMERA",
            brand = "思翼 SIYI",
            model = "UniPod MT11 四光 AI 吊舱",
            tags = "SIYI,思翼,UniPod,MT11,四光,热成像",
            datasheetUrl = SIYI_MT11,
            favorite = false,
            time = T0 + 210,
            notes = """
四传感器 AI 光电吊舱：4800 万广角 + 11× 光学 / 165× 混合变焦 + 640×512 红外（8× 数码变焦）+ 激光测距 5~1200 m。内置约 10T AI（人/车/船/火焰等，见官网场景页）。三轴增稳。视频以太网。控制：S.Bus、UART、以太网 TCP/UDP。

电压 10~26 V（3~6S），需独立供电。平均功耗约 11.4 W（静止）。IP54（实验室 IEC 60529，非永久）。-20~50℃。
重量：不含快拆 405±5 g；含快拆减震板+扩展坞 533.5±5 g。
尺寸：不含快拆爪约 90×102.5×128 mm；含快拆约 141.5×141.5×169 mm。实验室最大空速 140 km/h。

产品页 $SIYI_MT11
中文入口 $SIYI_MT11_ZH
            """.trimIndent(),
            specs = listOf(
                SpecField("可见光", "48MP / 11× 光学 / 165× 混合"),
                SpecField("红外", "640×512 / 8× 数码"),
                SpecField("测距", "5~1200", "m"),
                SpecField("AI", "约 10T 内置"),
                SpecField("控制", "S.Bus / UART / 以太网"),
                SpecField("电压", "10~26（3~6S）", "V"),
                SpecField("防护", "IP54"),
                SpecField("重量", "405±5 / 含快拆 533.5±5", "g"),
                SpecField("尺寸(裸机)", "90×102.5×128", "mm"),
            ),
        ),
        device(
            id = "skydroid-g16",
            type = "OTHER",
            brand = "云卓 Skydroid",
            model = "G16 手持地面站",
            tags = "云卓,Skydroid,G16,地面站,GR01",
            datasheetUrl = SKYDROID_G16_MANUAL,
            favorite = false,
            time = T0 + 200,
            notes = """
说明书：高通 6nm，Android 13，7 寸工业触摸 + 阳光屏 1920×1200，4G+64G。20000mAh，约 9~10 h。1.05 kg，272×183×94 mm。2.4/5.8G 双频自动跳频，16 通道，视距对空约 5~30 km。射频 23 dBm@CE/FCC。-10~60℃。接口：TYPE-C 充电、USB-A、SIM、PPM。

配套天空端 GR01：7.2~72 V XT30，2.4/5.8G，SBUS + 数传 + 网口 + 3 路 PWM，约 37 g，45.5×60×21.5 mm。串口波特率 57600 / 115200 / 921600。

对频：接收机对频键蓝灯快闪后，地面端「设备助手」开始对频，距离约 50 cm 内。也可接收机快开四次进对频。
QGC 数传：UDP，监听 14551，服务器 127.0.0.1:14552。
图传：相机 IP 需在 192.168.144.x，网关 192.168.144.11。C10 Pro 例：rtsp://192.168.144.108:554/stream=0。FLY 地面站组合选 S2+G12+G20+G30。S2 飞控只用 FLY，不要用 QGC。

说明书 $SKYDROID_G16_MANUAL
官网 $SKYDROID_SITE
            """.trimIndent(),
            specs = listOf(
                SpecField("屏幕", "7 寸 1920×1200 阳光屏"),
                SpecField("系统", "Android 13 / 高通 6nm / 4+64 GB"),
                SpecField("电池", "20000 mAh / 约 9~10h"),
                SpecField("频段", "2.4 / 5.8 GHz"),
                SpecField("距离", "视距对空约 5~30", "km"),
                SpecField("通道", "16"),
                SpecField("尺寸", "272×183×94", "mm"),
                SpecField("重量", "1.05", "kg"),
                SpecField("天空端", "GR01 7.2~72 V XT30"),
            ),
        ),
        device(
            id = "skydroid-g20",
            type = "OTHER",
            brand = "云卓 Skydroid",
            model = "G20 手持地面站",
            tags = "云卓,Skydroid,G20,地面站",
            datasheetUrl = SKYDROID_G20,
            favorite = false,
            time = T0 + 190,
            notes = """
云卓海外产品页：高通 6nm 八核，Android 13，7 寸 1920×1200 高亮，2.4/5.8G 自动跳频 + MCS，图数传最远约 30 km。SIM / USB / Type-C。双风扇。满电工作写 6~8 h。可装主流地面站 APP。

经销商规格表另写：8 GB + 128 GB，20000mAh 约 8~12 h，36 W PD，1.2 kg，277×138×96 mm，-10~55℃，16 通道，另有网口；天空端常配 GR01（7.2~72 V XT30）。以上以官网说明书为准。

FLY 地面站连接组合含 G20（与 G16 说明书同一套助手逻辑）。波特率、144 网段、RTSP 与 G16 同类，见「云卓地面站连接要点」。

产品页 $SKYDROID_G20
            """.trimIndent(),
            specs = listOf(
                SpecField("屏幕", "7 寸 1920×1200"),
                SpecField("系统", "Android 13 / 高通 6nm 八核"),
                SpecField("存储(经销商表)", "8 GB + 128 GB"),
                SpecField("电池", "海外页 6~8h；表写 20000mAh 8~12h"),
                SpecField("频段", "2.4 / 5.8 GHz"),
                SpecField("距离", "约 30", "km"),
                SpecField("充电", "经销商表 36W PD"),
                SpecField("尺寸/重量(表)", "277×138×96 mm / 1.2 kg"),
            ),
        ),
        device(
            id = "skydroid-h16",
            type = "OTHER",
            brand = "云卓 Skydroid",
            model = "H16 / H16 Pro 手持地面站",
            tags = "云卓,Skydroid,H16,H16 Pro,地面站,R16",
            datasheetUrl = SKYDROID_H16_MANUAL,
            favorite = false,
            time = T0 + 180,
            notes = """
H16 与 H16 Pro 硬件接口相同，差别主要是距离。CUAV/说明书：理想环境 H16 约 10 km，H16 Pro 约 30 km；参考距离另写约 8 / 20 km，以实测为准。2.400~2.483 GHz，FHSS。16 通道。澎湃 S1 + 安卓。7 寸高亮，CUAV 表 2000 nit（2024 双语说明书另写 1800 nits IPS）。1920×1200。20000mAh，续航表写 8~15 h（另有表 6~20 h）。重量 1034 g。尺寸 272×183×94 mm（个别表 384 为笔误）。-10~55℃。接口：网口、TYPE-C、OTG、USB，另有 TF / HDMI / PPM（见版本）。部分材料写 IP67 级防护结构。

天空端：较新说明书为 R16，7.2~72 V，约 90 g，约 76×69×11 mm。MIPI / HDMI / RJ45 / BAT+SBUS / TYPE-C。功耗约 2.4 W。

QGC：数传 UDP 端口 14550（助手 FAQ 也提到 14551）。网口相机默认天空端 IP 192.168.144.10、地面 192.168.144.11。MIPI/HDMI 例：rtsp://192.168.0.10:8554/H264Video。热点分享：Mission Planner TCP 192.168.43.1:5760；视频 rtsp://192.168.43.1:8554/fpv_stream。充电：专配充电器进快充；另有说明写 TYPE-C 9V 2A。

说明书 $SKYDROID_H16_MANUAL
            """.trimIndent(),
            specs = listOf(
                SpecField("屏幕", "7 寸 1920×1200 / 约 2000 nit"),
                SpecField("频段", "2.400~2.483 GHz FHSS"),
                SpecField("距离", "H16≈10 km / Pro≈30 km 理想"),
                SpecField("电池", "20000 mAh / 约 8~15h"),
                SpecField("通道", "16"),
                SpecField("尺寸", "272×183×94", "mm"),
                SpecField("重量", "1034", "g"),
                SpecField("天空端", "R16 7.2~72 V / 约 90 g"),
            ),
        ),
        device(
            id = "skydroid-h30",
            type = "OTHER",
            brand = "云卓 Skydroid",
            model = "H30 手持地面站",
            tags = "云卓,Skydroid,H30,R30,地面站",
            datasheetUrl = SKYDROID_H30_MANUAL,
            favorite = false,
            time = T0 + 170,
            notes = """
说明书：骁龙 660 八核，Android 9，10.1 寸 1920×1200 高亮 IPS，1080p 数字图传。16 通道。800M / 1.4G / 2.4G 三频跳频（另有介绍只强调 1.4G/2.4G）。20000mAh，约 5 h。4G+64G。1.5 kg。346×196.5×89.4 mm（早期英文 PDF 另有 361×393.2×102.4 mm / 2.24 kg，以现行说明书 1.5 kg 表为准）。TYPE-C。-10~55℃。IP65。接口：HDMI、RJ45、SIM、USB、TF、PPM、双串口。

天空端 R30：16 通道，7.2~72 V，约 65 g，76.4×59×15 mm。双网口、双串口、SBUS。出厂已对频，上电约 20 s 自动连接。换机需重新对频。

QGC / Tower：串口 0 → 192.168.144.101:14550；串口 1 → :14551。C10：rtsp://192.168.144.108:554/stream=0。相机 144 网段。

说明书 $SKYDROID_H30_MANUAL
            """.trimIndent(),
            specs = listOf(
                SpecField("屏幕", "10.1 寸 1920×1200"),
                SpecField("系统", "Android 9 / 骁龙 660 / 4+64 GB"),
                SpecField("频段", "800M / 1.4G / 2.4G"),
                SpecField("电池", "20000 mAh / 约 5h"),
                SpecField("通道", "16"),
                SpecField("尺寸", "346×196.5×89.4", "mm"),
                SpecField("重量", "1.5", "kg"),
                SpecField("防护", "IP65"),
                SpecField("天空端", "R30 7.2~72 V / 约 65 g"),
            ),
        ),
        device(
            id = "unicore-um982",
            type = "GPS",
            brand = "和芯星通 Unicore",
            model = "UM982 全频 RTK 定向模块",
            tags = "和芯星通,Unicore,UM982,RTK,GNSS,双天线",
            datasheetUrl = UNICORE_UM982,
            favorite = true,
            time = T0 + 160,
            notes = """
NebulasIV SoC，1408 通道。全系统全频片上 RTK + 双天线定向。主从天线同时跟踪，Dual-RTK 主从独立解算。可作移动站或基准站。抗干扰 / 防欺骗。面向无人机、自主机器、精准农业。

系统：BDS B1I/B3I/B1C*/B2a/B2b*；GPS L1C/A/L2C/L2P(Y)/L5；GLONASS G1/G2；Galileo E1/E5a/E5b/E6*；QZSS L1C/A/L2C/L5/L6*；SBAS L1C/A。* 为特定固件。

RTK RMS：平面 0.8 cm+1 ppm，高程 1.5 cm+1 ppm。定向 0.1°/1 m 基线。更新率 20 Hz（RTK+Heading）。差分 RTCM 3.x。NMEA-0183 + Unicore。单点平面 1.5 m / 高程 2.5 m。冷启动 <30 s，初始化典型 <5 s。

封装 48 pin LGA，16.0×21.0×2.6 mm，1.82±0.03 g。VCC 3.0~3.6 V（典型 3.3 V），典型电流约 152 mA @3.3 V，功耗约 500 mW。-40~+85℃。UART×3（LVTTL）；I2C / SPI / CAN*（CAN 与 UART3 复用）。

无人机：主天线定位、从天线定向，基线尽量长且刚固（1 m 基线约 0.1°）。两天线相位中心同高、远离桨/数传。飞控常见 115200，以模块配置为准。V_BCKP 不用热启动时接 VCC，勿悬空。天线馈电与 VCC 分开电源轨。

产品页 $UNICORE_UM982
手册 $UNICORE_UM982_MANUAL
简报 $UNICORE_UM982_BRIEF
            """.trimIndent(),
            specs = listOf(
                SpecField("芯片", "NebulasIV / 1408 通道"),
                SpecField("定位", "全系统全频 RTK + 双天线定向"),
                SpecField("RTK平面", "0.8 cm + 1 ppm"),
                SpecField("RTK高程", "1.5 cm + 1 ppm"),
                SpecField("定向", "0.1° / 1 m 基线"),
                SpecField("更新率", "20 Hz（RTK+Heading）"),
                SpecField("差分/协议", "RTCM 3.x / NMEA-0183 / Unicore"),
                SpecField("封装", "16.0×21.0×2.6 mm LGA"),
                SpecField("供电", "3.0~3.6（典型 3.3）", "V"),
                SpecField("接口", "UART×3 / I2C* / SPI* / CAN*"),
                SpecField("温度", "-40~+85", "℃"),
            ),
        ),
        device(
            id = "ublox-zed-f9p",
            type = "GPS",
            brand = "u-blox",
            model = "ZED-F9P 多频 RTK 模块",
            tags = "u-blox,ublox,ZED-F9P,F9P,RTK,GNSS",
            datasheetUrl = UBLOX_F9P,
            favorite = true,
            time = T0 + 155,
            notes = """
u-blox F9 多频高精度 GNSS。同时接收 GPS/QZSS、GLONASS、Galileo、BeiDou（4 系统）。常见 02B 等为 L1/L2 类双频；15B 为 L1/L5 类。184 通道 F9 引擎。厘米级 RTK：产品摘要 RTK 0.01 m + 1 ppm CEP，收敛 <10 s。导航更新率 RTK 最高 20 Hz（最高速率可能限制星座数）。单模块单天线定位，不能单芯片双天线定向。航向要用两套 F9P（moving base，0xB 版本支持）或换 UM982 这类双天线模块。

可作 rover 或 base（survey-in / 固定坐标）。协议：NMEA、UBX、RTCM 3.3/3.4、SPARTN。接口：UART×2、USB、SPI、I2C（SPI 与 UART/I2C 复用，D_SEL=低才启用）。UART 默认常见 38400 8N1（见对应版本数据手册）。供电 2.7~3.6 V，连续约 68 mA @3.0 V。备份 1.65~3.6 V。封装 54 pin LGA，17.0×22.0×2.4 mm。-40~+85℃。外接有源天线。抗干扰 / 抗欺骗（部分版本 OSNMA）。

无人机常见：Here3 / Here4 等板载 F9P，ArduPilot / PX4 作 GPS1 + GPS2（yaw）。基站发 RTCM3，移动站串口或 USB 收。双 F9P 航向：移动基站+从模块，基线刚固，GPS_AUTO_CONFIG / GPS1_TYPE 等按飞控文档。

产品页 $UBLOX_F9P
数据手册 $UBLOX_F9P_DS
产品摘要 $UBLOX_F9P_SUM
            """.trimIndent(),
            specs = listOf(
                SpecField("引擎", "u-blox F9 / 184 通道"),
                SpecField("系统", "GPS QZSS / GLONASS / Galileo / BDS"),
                SpecField("RTK", "0.01 m + 1 ppm CEP"),
                SpecField("更新率", "RTK 最高 20", "Hz"),
                SpecField("航向", "单模块无双天线；需两套/moving base"),
                SpecField("协议", "NMEA / UBX / RTCM 3.x / SPARTN"),
                SpecField("接口", "UART×2 / USB / I2C / SPI"),
                SpecField("封装", "17.0×22.0×2.4 mm LGA"),
                SpecField("供电", "2.7~3.6", "V"),
                SpecField("温度", "-40~+85", "℃"),
            ),
        ),
        device(
            id = "hobbywing-h150a-foc",
            type = "ESC",
            brand = "好盈 Hobbywing",
            model = "XRotor Pro H150A 24S FOC",
            tags = "H150,H150A,H150A FOC,好盈,Hobbywing,FOC,UAVCAN,24S",
            datasheetUrl = H150_PRODUCT,
            favorite = true,
            time = T0 + 310,
            notes = """
独立零售电调，官网品名 XRotor Pro H150A 24S FOC（搜索 H150 / H150A）。H13MD 产品页把套装电调也写成 H150A FOC，但参数不是这一台：套装电调 30~130 V、持续 60 A、395 g、132.5×67.5×37.4 mm（带插头），见「H13MD 电调 H150A FOC」。本条以独立产品页为准。

官网技术参数：电压 18-24S（54-104.4 V），持续 50 A（散热良好），峰值 150 A / 3 s。尺寸 164×66×38 mm，重量 464 g（不含线）。IP55，可定制 IP67。环境 -20~50℃。FOC 矢量控制，电机参数严格匹配（一机一程序）。桨叶定位可选霍尔，标品无。

油门：PWM + CAN 双油门，信号全隔离。PWM 脉宽 1100-1940 μs，频率 50-500 Hz，电平 5V/3.3V。油门行程出厂固化，不可校准，软件可调参。通讯 CAN（可定制串口）。调参盒 DataLinkBox G3。故障存储 / 黑匣子：转速、油门、电流、电压、MOS/电容温度。页写上电自检、欠压、过压、过流、油门丢失、无限重启。可用 DataLink 升级；飞控远程升级为可选项。

同系列另有 XRotor H150A 14S FOC（12-14S / 44-60.9 V，持续 60 A，198 g，116×49.4×29.6 mm），不要和 24S 零售款或 H13MD 套装电调混用参数。

ArduPilot / PX4：PWM 接主出、脉宽按 1100-1940，不要做油门行程校准。CAN 数字油门走飞控 CAN，总线 500 kbps 常见，同机 ID/通道不能重复；无终端电阻时按整机拓扑补电阻。与 H13MD 共轴套一起用时，套装电调仍以 H13 说明书为准（无低压切断、油门丢失立即关输出、过流约 360 A）。

产品页 $H150_PRODUCT
英文页 $H150_PRODUCT_EN
说明书 $H150_MANUAL
规格图 $H150_SPEC_DWG
14S 页 $H150_14S
H13MD 页 $H13_PRODUCT_PAGE
            """.trimIndent(),
            specs = listOf(
                SpecField("产品型号", "XRotor Pro H150A 24S FOC"),
                SpecField("俗称", "H150 / H150A FOC"),
                SpecField("电压范围", "18-24S（54-104.4V）"),
                SpecField("持续电流", "50（散热良好）", "A"),
                SpecField("峰值电流", "150A / 3s"),
                SpecField("驱动", "FOC"),
                SpecField("通讯", "CAN（可定制串口）"),
                SpecField("双油门", "PWM + CAN"),
                SpecField("PWM脉宽", "1100-1940", "μs"),
                SpecField("PWM频率", "50-500", "Hz"),
                SpecField("PWM电平", "5V / 3.3V"),
                SpecField("油门校准", "固化不可校准"),
                SpecField("信号隔离", "全隔离"),
                SpecField("调参盒", "DataLinkBox G3"),
                SpecField("故障存储", "支持"),
                SpecField("防护等级", "IP55（可定制 IP67）"),
                SpecField("尺寸", "164×66×38", "mm"),
                SpecField("重量(不含线)", "464", "g"),
                SpecField("工作温度", "-20~50", "℃"),
                SpecField("H13套装电调", "不同规格，见 hobbywing-h13md-esc"),
                SpecField("产品页", H150_PRODUCT),
                SpecField("说明书PDF", H150_MANUAL),
                SpecField("规格图", H150_SPEC_DWG),
            ),
        ),
        device(
            id = "cuav-x7",
            type = "FLIGHT_CONTROLLER",
            brand = "CUAV",
            model = "X7 飞控",
            tags = "CUAV,X7,飞控,STM32H7,ArduPilot,PX4",
            datasheetUrl = CUAV_X7_AP,
            favorite = false,
            time = T0 + 305,
            notes = """
CUAV 自研 STM32H7 工业飞控，兼容 ArduPilot / PX4。模块化核心，载板可 DIY，兼容 V5+ 载板。内置减震、IMU 加热/温补、三套 IMU。官网系列页：因硬件改版，X7+ 已替代 X7（约 2021-12-15），X7 不再生产；现场仍大量在飞，本条记第一代 X7。

MCU：STM32H743。IMU（ArduPilot 族谱 / CUAV X7+ 页括号）：BMI088、ICM-20689、ICM-20649。罗盘 RM3100。气压计 MS5611×2。
口：PWM 14 路（12 路 DShot）；双向 DShot 6 路（M9~M14）。RCIN：SBUS / PPM / DSM。RSSI：模拟 / PWM。GPS×2（GPS + UART4）。I2C：ArduPilot 写 4 总线（2 个外口）；CUAV 页写 6 路（4 独立 + GPS/UART4 内 2）。CAN×2。电源×2：Power A 模拟电流计，Power C DroneCAN/UAVCAN 电池口。ADC×2。USB-C。无舵机轨电压监测（相对 X7+）。

供电：ArduPilot 4.3~5.4 V，USB 4.75~5.25 V。CUAV X7+ 页写 PM 4.5~5.5 V。早期 X7 页舵机轨 0~36 V；X7+ 页舵机 0~10 V。重量 101 g。温度：ArduPilot 实测 -20~80℃；CUAV + 页写 -20~85℃。

固件：ArduPilot 文件夹 CUAV-X7（双向 DShot 用 CUAV-X7-bdshot）。PX4 亦支持该系列。串口默认：USB 控制台、TELEM1/2、GPS1=USART1、GPS2=UART4。CRSF/ELRS 不要走 RCIN，改 UART（常用 SERIAL6/UART7，协议 23）。

后继 X7+：IMU 改为 ICM-42688-P + ICM-20689×2，双向 DShot 12 路（M1~M12），可监测舵机电压（最高约 9.9/10 V）。不要把 X7+ 参数抄到本条。

文档 $CUAV_X7_SERIES
X7+ 页（含 X7 IMU 对照） $CUAV_X7_PLUS
ArduPilot $CUAV_X7_AP
官网 $CUAV_SITE
            """.trimIndent(),
            specs = listOf(
                SpecField("MCU", "STM32H743"),
                SpecField("陀螺仪/加计", "BMI088 / ICM-20689 / ICM-20649"),
                SpecField("罗盘", "RM3100"),
                SpecField("气压计", "MS5611×2"),
                SpecField("固件", "ArduPilot CUAV-X7 / PX4"),
                SpecField("PWM", "14（12 路 DShot）"),
                SpecField("双向DShot", "6（M9~M14）"),
                SpecField("CAN", "2"),
                SpecField("UART", "GPS×2 + TELEM 等（见说明书）", "路"),
                SpecField("I2C", "4 总线 / CUAV 页写 6"),
                SpecField("GPS口", "2（GPS + UART4）"),
                SpecField("电源口", "Power A 模拟 + Power C DroneCAN"),
                SpecField("USB", "USB-C"),
                SpecField("舵机电压监测", "无（X7+ 才有）"),
                SpecField("输入电压", "4.3~5.4 V（AP）；CUAV+ 页 4.5~5.5 V"),
                SpecField("USB电压", "4.75~5.25", "V"),
                SpecField("重量", "101", "g"),
                SpecField("工作温度", "-20~80（AP 实测）/ +页 -20~85", "℃"),
                SpecField("后继", "X7+（2021-12-15 起）"),
            ),
        ),
        device(
            id = "cuav-x7-pro",
            type = "FLIGHT_CONTROLLER",
            brand = "CUAV",
            model = "X7 Pro 飞控",
            tags = "CUAV,X7 Pro,X7+ Pro,飞控,ADIS16470,STM32H7,ArduPilot,PX4",
            datasheetUrl = CUAV_X7_PRO,
            favorite = true,
            time = T0 + 300,
            notes = """
X7 系列工业款：同样 STM32H743 + 三 IMU + RM3100 + MS5611×2，主 IMU 换成车规 ADIS16470，长航时航姿更稳，抗磁靠工业罗盘。专利减震。模块化载板。官网：2022-01-01 起由 X7+ Pro 替代 X7 Pro，后者不再生产。

X7 Pro IMU（CUAV X7+ Pro 页括号 / ArduPilot 族谱）：ADIS16470、BMI088、ICM-20649。
X7+ Pro IMU：ADIS16470、ICM-42688-P、ICM-20689。其余接口与 X7 族相同：PWM 14（12 DShot），双向 DShot 仍 6 路（M9~M14）；X7+ Pro 才把双向 DShot 扩到 12 路（M1~M12）并增加舵机轨电压监测（最高约 9.9/10 V）。X7 / X7 Pro 无舵机电压监测。

口：CAN×2，GPS×2，Power A 模拟 + Power C DroneCAN，USB-C，RCIN SBUS/PPM/DSM。供电与 X7 同档：ArduPilot 4.3~5.4 V / USB 4.75~5.25 V。重量：族谱 X7 系列 101 g，X7+ Pro 写 105 g；CUAV X7+ Pro 页 103 g。温度 + 页 -20~85℃。

固件：ArduPilot CUAV-X7；X7+ Pro 文档写兼容 ArduPilot 4.10 / PX4 v1.12.3 及以上。刷机文件夹仍以 CUAV-X7 / CUAV-X7-bdshot 为准。接线、双 CAN、GPS、电流计见「CUAV 飞控接线要点」。

相对 V6X：X7 Pro 无以太网、PWM 14 路、H743；V6X 是 Pixhawk FMUv6X，H753 + IO 协处理，16 路 PWM，100M 网口。不要混刷固件。

文档 $CUAV_X7_PRO
系列对照 $CUAV_X7_SERIES
ArduPilot $CUAV_X7_AP
官网 $CUAV_SITE
            """.trimIndent(),
            specs = listOf(
                SpecField("MCU", "STM32H743"),
                SpecField("陀螺仪/加计", "ADIS16470 / BMI088 / ICM-20649"),
                SpecField("罗盘", "RM3100"),
                SpecField("气压计", "MS5611×2"),
                SpecField("固件", "ArduPilot CUAV-X7 / PX4"),
                SpecField("PWM", "14（12 路 DShot）"),
                SpecField("双向DShot", "6（M9~M14）"),
                SpecField("CAN", "2"),
                SpecField("GPS口", "2（GPS + UART4）"),
                SpecField("电源口", "Power A 模拟 + Power C DroneCAN"),
                SpecField("USB", "USB-C"),
                SpecField("舵机电压监测", "X7 Pro 无；X7+ Pro 有（≤10 V）"),
                SpecField("输入电压", "4.3~5.4 V（AP）"),
                SpecField("重量", "101 g；X7+ Pro 103~105 g"),
                SpecField("工作温度", "-20~85", "℃"),
                SpecField("后继", "X7+ Pro（2022-01-01 起）"),
                SpecField("相对V6X", "无以太网 / 14 PWM / 无独立 IO 芯片"),
            ),
        ),
        device(
            id = "cuav-v6x",
            type = "FLIGHT_CONTROLLER",
            brand = "CUAV",
            model = "Pixhawk V6X 飞控",
            tags = "CUAV,V6X,Pixhawk V6X,FMUv6X,以太网,STM32H753,ArduPilot,PX4",
            datasheetUrl = CUAV_V6X,
            favorite = true,
            time = T0 + 295,
            notes = """
CUAV 与 PX4 按 Pixhawk FMUv6X / Autopilot Bus / 连接器标准做的模块化飞控。H7 双精度浮点 + Cortex-M3 IO 协处理。三套 IMU 独立总线、独立 LDO；双气压计；IMU 加热/出厂温补；专利减震。集成 100 Mbps 以太网 PHY，给任务机、测绘相机、光纤惯导走网口。核心 / IMU / 载板用 100+50 pin 总线分开。

V1（PX4 文档 / 初代 Pixhawk V6X）
MCU：STM32H753（480 MHz，2 MB Flash，1 MB RAM）。IO：STM32F103（72 MHz，20 KB SRAM）。IMU：BMI088、ICM-42688-P、ICM-20649。罗盘 RM3100。气压计 ICP-20100×2。
口：PWM 16（M1~M8 来自 IO，A1~A8 来自 FMU）。TELEM×3（全流控）、UART4、GPS1（含安全开关）+ GPS2、USB Type-C + GH、ETH 100M、SPI 外扩、CAN×2、电源 4 口（POWER C1/C2 = DroneCAN，POWER1/2 = SMBus/I2C）。AD&IO。PWM 电平 3.3 V。
电：电源轨工作约 4.75~5.7 V，USB 4.75~5.25 V，舵机轨 0~9.9 V（绝对最大舵机 42 V 不损坏）。重量约 99 g（核心 43 g + 底板 56 g）。尺寸约 90.1×45.0×29.2 mm。温度 -20~85℃。配套常见 CAN PMU Lite（约 110 A / 62 V）。本板不支持模拟 ADC 电流计（换载板另说）。

V2（现行 CUAV 文档 Pixhawk V6X v2）
MCU 写 STM32H753IIK6 + STM32F103。IMU 文档写 IIM-62452 / BMI088 / ICM-42686；商店对照表写 IIM-42652 / BMI088 / ICM-45686，以板端丝印 + 当前文档为准。气压计 ICP-20100 / BMP581。电源口改为 2。PWM 电平 3.3 V / 5 V 可配。重量 97.9 g（核心 43.1 + 载板含螺丝 54.8）。尺寸 45×85.1×29.2 mm。标配 PMU 2 Lite 5V，输入 12~70 V。POWER 4.85~5.45 V。载板兼容 V1，固件互不兼容。

固件
• ArduPilot：V1 常用 Pixhawk6X；V2 板型 CUAV-V6X-v2（文档曾写稳定版未齐、需 beta，以地面站当前列表为准）。
• PX4：V1 `px4_fmu-v6x_default`；V2 `cuav_fmu-v6x_default`。不要互刷。

相对 X7 / X7 Pro：V6X 有以太网、16 路 PWM、独立 IO 芯片、Pixhawk 标准总线；X7 族是 H743、14 PWM、Power A+C、无网口。双 CAN、GPS1/GPS2、DroneCAN 电调/电流计接法见「CUAV 飞控接线要点」。

文档 $CUAV_V6X
V1 页 $CUAV_V6X_V1
PX4 $CUAV_V6X_PX4
官网 $CUAV_SITE
            """.trimIndent(),
            specs = listOf(
                SpecField("MCU", "STM32H753 + IO STM32F103"),
                SpecField("标准", "Pixhawk FMUv6X"),
                SpecField("陀螺仪/加计(V1)", "BMI088 / ICM-42688-P / ICM-20649"),
                SpecField("陀螺仪/加计(V2)", "文档 IIM-62452/BMI088/ICM-42686"),
                SpecField("罗盘", "RM3100"),
                SpecField("气压计", "V1：ICP-20100×2；V2：ICP-20100/BMP581"),
                SpecField("固件", "ArduPilot Pixhawk6X / CUAV-V6X-v2；PX4 FMUv6X"),
                SpecField("PWM", "16"),
                SpecField("以太网", "100 Mbps"),
                SpecField("CAN", "2"),
                SpecField("TELEM", "3"),
                SpecField("GPS口", "2（GPS1 含安全开关）"),
                SpecField("电源口", "V1：4（2×CAN+2×I2C）；V2：2"),
                SpecField("USB", "Type-C + JST GH"),
                SpecField("输入电压", "V1 电源约 4.75~5.7 V"),
                SpecField("舵机轨", "0~9.9", "V"),
                SpecField("重量", "V1≈99 g / V2 97.9 g"),
                SpecField("工作温度", "-20~85", "℃"),
                SpecField("相对X7", "有网口、16 PWM、H753+IO"),
            ),
        ),
        device(
            id = "benewake-tf02-pro",
            type = "OTHER",
            brand = "北醒 Benewake",
            model = "TF02-Pro 激光雷达",
            tags = "北醒,Benewake,TF02-Pro,TF02Pro,TF02,LiDAR,测距,定高",
            datasheetUrl = TF02_PRO_MANUAL,
            favorite = true,
            time = T0 + 320,
            notes = """
北醒中距单点 ToF。官网品名 TF02-Pro（TF02 升级款）。无人机定高、交通、停车、农业。手册：优化光学与算法，室外强光 / 不同反射率 / 温度更好用。

量程（手册 Table 1-1，90% 白板）：0.1~40 m（0 Klux 与 100 Klux 相同）。10% 反射率：0.1~13.5 m。精度 ±5 cm（0.1~5 m）、±1%（5~40 m）。分辨率 1 cm。帧率 1~1000 Hz，默认 100 Hz（定制帧率按 2000/n，n≥2）。重复性 1σ <2 cm（0.1~35 m @90%）。抗光 100 Klux。IP65。人眼安全 Class1（IEC60825）。波长 850 nm，VCSEL。FOV 理论 3°（实际略偏）。

电：DC 5~12 V，平均 ≤200 mA，峰值 300 mA，功耗 ≤1 W。电平 LVTTL 3.3 V。接口 UART / I²C / I/O。尺寸 69×41.5×26 mm（L×H×W），外壳 PC/ABS。-20~60℃，储存 -30~80℃。重量 50 g（含线），线长 80 cm。插头 JST 1.25-4P（Molex 51021-0400）。
线序：红 VCC，白 RXD/SDA，绿 TXD/SCL，黑 GND。有反接保护（产品页）。

UART：默认 115200 8N1。I²C：从机，默认地址 0x10，范围 0x01~0x7F，最高 400 kbps；发命令后约等 100 ms 再读。安装 M2.5 圆头十字。先撕镜头保护膜，镜面即测距零点，不要挡、不要用酒精擦。光斑随距离变大（1 m 约 5 cm 边长，40 m 约 208 cm），目标应大于光斑。

飞控：ArduPilot 串口 SERIAL_PROTOCOL=9，波特 115，RNGFND1_TYPE=27（BenewakeTF03，与 TF02-Pro 共用；旧 TF02 才是 19）。北醒 I²C 应用笔记：TYPE=25，ADDR=16（0x10），定高 ORIENT=25，MIN/MAX 按安装与有效量程。Wiki 表把 TF02-Pro 保守写成 0.40~13.5 m（偏 10% 反射率），参数不要按 40 m 满量程写死。PX4 有 Benewake 测距驱动，以当前文档为准。
不要和 TF02-i（CAN，7~30 V）混料。

产品页 $TF02_PRO
中文页 $TF02_PRO_ZH
手册 $TF02_PRO_MANUAL
I²C+ArduPilot $TF02_PRO_I2C_AP
ArduPilot $BENEWAKE_AP
            """.trimIndent(),
            specs = listOf(
                SpecField("产品型号", "TF02-Pro"),
                SpecField("原理", "ToF 单点"),
                SpecField("量程@90%", "0.1~40", "m"),
                SpecField("量程@10%", "0.1~13.5", "m"),
                SpecField("精度", "±5 cm（≤5 m）/ ±1%（5~40 m）"),
                SpecField("分辨率", "1", "cm"),
                SpecField("帧率", "1~1000（默认 100）", "Hz"),
                SpecField("FOV", "3", "°"),
                SpecField("波长", "850 nm VCSEL / Class1"),
                SpecField("接口", "UART / I²C / I/O"),
                SpecField("UART", "115200 8N1"),
                SpecField("I²C", "从机 0x10 / ≤400 kbps"),
                SpecField("电压", "DC 5~12", "V"),
                SpecField("功耗", "≤1", "W"),
                SpecField("防护", "IP65"),
                SpecField("尺寸", "69×41.5×26", "mm"),
                SpecField("重量(含线)", "50", "g"),
                SpecField("线长", "80", "cm"),
                SpecField("温度", "-20~60", "℃"),
                SpecField("手册", TF02_PRO_MANUAL),
            ),
        ),
        device(
            id = "benewake-tf03",
            type = "OTHER",
            brand = "北醒 Benewake",
            model = "TF03 激光雷达（100 / 180）",
            tags = "北醒,Benewake,TF03,TF03-180,TF03-100,LiDAR,测距,CAN",
            datasheetUrl = TF03_MANUAL,
            favorite = true,
            time = T0 + 315,
            notes = """
北醒第三代长距单点脉冲 ToF。官网 SKU：TF03-100 与 TF03-180，手册写二者只差最大量程。用户说 TF03 时现场多是 180 m 款，买料先看丝印/订单。铝合金壳 + 红外透过玻璃，IP67。另有无外壳定制（约 10 g / 31.0×30.2×19.2 mm），参数问北醒，本条不记。

量程（UART/CAN 手册 Table 2，90% / 10% × 0 klux / 100 klux；斜杠为 100 款 / 180 款）：
• 90% 0 klux：0.1~100 m / 0.1~180 m
• 10% 0 klux：0.1~40 m / 0.1~70 m
• 90% 100 klux：0.1~80 m / 0.1~130 m
• 10% 100 klux：0.1~30 m / 0.1~50 m
精度 ±10 cm（10 m 内）、1%（10 m 以外）。分辨率 1 cm。帧率 1~1000 Hz，默认约 100 Hz（须满足手册公式，否则回 100 Hz）。重复性 1σ <3 cm。光源 LD，905 nm，Class1（EN60825）。FOV 水平 0.5°、垂直 0.15°（理论值）。抗光 100 kLux。

电：5~24 V DC。平均电流 ≤150 mA@5 V / ≤80 mA@12 V / ≤50 mA@24 V。功耗 ≤1 W。过压保护 300 V，反接 200 V。LVTTL 3.3 V。标准版 UART/CAN（默认 UART，二者不能同时出数，命令切换）。另有 RS485/RS232 版。尺寸 44×43×32 mm。重量手册表 86 / 89 / 92 g。线长 70 cm。Molex SD-51021-007 / MH1.25-7P。-25~60℃，储存 -40~85℃。
线序：红 5~24 V，白 CAN_L，绿 CAN_H，蓝 UART RX，棕 UART TX，黑 GND。UART 115200 8N1。CAN 默认 1 Mbps，收 ID 0x3003，发 ID 0x03，标准帧。

现场：勿挡窗口；雨雾烟、同波长强光、凝露、高压水枪、剧烈振动会失效。可选自清洁 / 瞄准光模块。
飞控：UART 与 TF02-Pro 相同套路，TYPE=27。CAN：CAN_Px_DRIVER=1，CAN_Dx_PROTOCOL=11（Benewake），TYPE=34。Wiki 保守表写 TF03 1~50 m，定高 MIN/MAX 按工况留余量，不要按 180 m 满量程。PX4 以当前 Benewake 驱动说明为准。

产品页 $TF03
中文页 $TF03_ZH
手册 $TF03_MANUAL
规格 PDF $TF03_SPEC
ArduPilot $BENEWAKE_AP
            """.trimIndent(),
            specs = listOf(
                SpecField("产品型号", "TF03-100 / TF03-180"),
                SpecField("原理", "脉冲 ToF 单点"),
                SpecField("量程@90% 0klux", "100 / 180", "m"),
                SpecField("量程@10% 100klux", "30 / 50", "m"),
                SpecField("精度", "±10 cm（≤10 m）/ 1%（>10 m）"),
                SpecField("分辨率", "1", "cm"),
                SpecField("帧率", "1~1000（默认约 100）", "Hz"),
                SpecField("FOV", "水平 0.5° / 垂直 0.15°"),
                SpecField("波长", "905 nm LD / Class1"),
                SpecField("接口", "UART / CAN（默认同 UART；另有 485/232 版）"),
                SpecField("UART", "115200 8N1"),
                SpecField("CAN", "默认 1 Mbps / TX 0x03 / RX 0x3003"),
                SpecField("电压", "DC 5~24", "V"),
                SpecField("功耗", "≤1", "W"),
                SpecField("防护", "IP67"),
                SpecField("尺寸", "44×43×32", "mm"),
                SpecField("重量", "86~92", "g"),
                SpecField("线长", "70", "cm"),
                SpecField("温度", "-25~60", "℃"),
                SpecField("手册", TF03_MANUAL),
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
        Article(
            id = "h13-wiring",
            title = "H13MD 接线与线序",
            category = "WIRING",
            tags = "H13,H13MD,接线,CAN,PWM",
            favorite = true,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
电源
• 12AWG 硅胶线，红正黑负，长度 1440±20 mm
• 改焊必须用足功率烙铁，焊点可靠

PWM 油门（黑白）
• 黑：GND
• 白：油门 Signal
• 插飞控对应电机口
• 脉宽 1100~1940 μs，频率 50~500 Hz
• 油门行程出厂固化，不支持校准

CAN（红灰）
• 红：CAN High（CH）
• 灰：CAN Low（CL）
• 用于数字油门、遥测、日志、升级
• 出厂 ID=1、通道=1，总线 500 kbps
• 同机各电调 ID 和通道不能重复
• 协议：UAVCAN，支持 DroneCAN
• 兼容开源飞控、微克、博鹰、极翼等（见官网）
• 接 DataLinkBox G3：红灰 → CH1/CL1，多电调可并联

数据
实时输出油门、转速、母线电流/电压、电容温度、MOS 温度。

线序以 H13-13825 说明书为准，不同批次外观可能略有差异。
            """.trimIndent(),
        ),
        Article(
            id = "h13-install",
            title = "H13MD 安装与碳管",
            category = "WIRING",
            tags = "H13,H13MD,安装,碳管",
            favorite = false,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
套装组成
电机×2、电调×2、桨叶×2、电机座×1、紧固螺钉、LED 灯组。出厂已组装，按转向标记直接装机臂。

碳管
• 外径 60 mm，壁厚约 2.5 mm（新闻/产品页；外形图内衬约 Φ55）
• 碳管内撑铝套 + 管夹座四向贯穿锁固 + 定位凸台
• 外形图碳管进深约 115 mm
• 电机座 3° 倾角，注意旋向。转向出厂已设定，不要对调相线
• 电调管夹座双侧布局，靠桨叶气流散热

桨
• MSC 54x20：420±15 g；MSC 57x20：480±15 g
• 安装：D40-4×M5，中心孔 D15
• 快拆桨座兼容两种孔位。依次：桨叶 → 桨夹盖（孔对准销钉）→ 左旋薄螺母 15 N·m → 右旋厚螺母 25 N·m
• 官网写这两颗螺母不需要螺丝胶
• 安装调试先卸桨

禁止
私改共轴结构、换电机/电调、用非配套桨。FOC 程序与电机+桨组合绑定。
            """.trimIndent(),
        ),
        Article(
            id = "h13-protect",
            title = "H13MD 保护与告警",
            category = "SAFETY",
            tags = "H13,H13MD,保护,告警",
            favorite = true,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
H13-13825 说明书：工业机电调，无低压保护、无过温停转。飞行中必须自己看电压和温度。

上电自检
通过后才能转；失败则不驱动并闪灯/鸣叫。

上电电压
低于 30 V 或高于 130 V：无法启动。运行中不再做低压切断。低于 30 V 器件会异常，立刻降落。

堵转
关输出并反复尝试重启。仍无法转：尽快降落；排除故障并断电再上电后才能恢复。

过流
瞬间相电流异常达 360 A：关输出并尝试重启。仍失败则断电再上电。

油门丢失
检测到丢失：立即关输出。信号恢复后立刻恢复功率。

过温警告（不停转）
MOS >110℃ 或电容 >100℃：经数据口上报，不降功率。持续过温会烧毁，减油门或降落。

灯语（说明书 / 产品页）
• 正常：常亮或连续短闪
• 过压 1 短；欠压 2 短；过流 3 短
• 油门丢失 1 长；油门未归零 1 长 1 短
• MOS 过温 1 长 2 短；电容过温 1 长 3 短；堵转 1 长 4 短

以说明书和现场灯语为准。
            """.trimIndent(),
        ),
        Article(
            id = "h13-thrust",
            title = "H13MD 拉力对照（24S/28S）",
            category = "MATCHING",
            tags = "H13,H13MD,拉力,24S,28S",
            favorite = true,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
实验室：25℃、海平面，变化油门测得。电机温度是 65% 油门跑 10 分钟。摘推荐点附近与最大拉力，完整表见官网，以官网为准。

—— MSC 54x20 / 92V（24S）  65% 约 86℃ ——
油门    拉力      电流     输入功率    力效
33%    17.5 kg   18.1 A    1.67 kW    10.5 g/W
45%    30.0 kg   38.5 A    3.54 kW     8.5 g/W
53%    40.7 kg   60.6 A    5.58 kW     7.3 g/W
55%    45.1 kg   71.8 A    6.34 kW     6.8 g/W
65%    59.0 kg  103.9 A    9.57 kW     6.2 g/W
80%    85.6 kg  188.2 A   17.32 kW     4.9 g/W
100%  107.0 kg  273.6 A   25.18 kW     4.2 g/W

—— MSC 54x20 / 108V（28S）  65% 约 80℃ ——
33%    17.9 kg   16.2 A    1.75 kW    10.3 g/W
55%    45.4 kg   60.8 A    6.57 kW     6.9 g/W
65%    61.7 kg   95.1 A   10.27 kW     6.0 g/W
100%  110.5 kg  245.8 A   26.56 kW     4.2 g/W

—— MSC 57x20 / 92V（24S）  65% 约 84℃ ——
33%    20.4 kg   21.6 A    1.99 kW    10.3 g/W
49%    40.9 kg   58.8 A    5.41 kW     7.6 g/W
52%    45.4 kg   68.9 A    6.34 kW     7.2 g/W
65%    66.8 kg  120.9 A   11.12 kW     6.0 g/W
100%  112.6 kg  284.5 A   26.19 kW     4.3 g/W

—— MSC 57x20 / 108V（28S）  65% 约 79℃ ——
33%    21.1 kg   19.6 A    2.12 kW    10.0 g/W
51%    45.8 kg   59.5 A    6.43 kW     7.1 g/W
65%    70.0 kg  110.6 A   11.95 kW     5.9 g/W
100%  113.0 kg  243.3 A   26.28 kW     4.0 g/W

读表
• 单轴推荐 45 kg：54x20 约 55%（24S 力效 6.8 g/W）；57x20 约 52%（24S 力效 7.2 g/W）
• 电调持续电流 60 A。24S 上 54x20 约 53%、57x20 约 49% 已接近 60 A，再往上是短时能力
• 110 / 113 kg 是海平面最大拉力，只能当机动/抗风余量
• 单轴起飞重量 = 整机起飞重量 ÷ 轴数，不得超过 45 kg
• 四轴八桨官网推荐起飞约 180 kg，任务载荷约 100 kg
            """.trimIndent(),
        ),
        Article(
            id = "h13-caution",
            title = "H13MD 使用注意",
            category = "SAFETY",
            tags = "H13,H13MD,安全",
            favorite = false,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
• 工业非载人配件。远离人群、高压线。遵守当地法规。
• 环境 -40~65℃。外部超过 65℃ 不要用。大风大雨雪雾雷电沙尘结冰不要飞。
• 防护 IP35，不是水下设备。
• 必须原厂配套桨。FOC 程序与电机+桨绑定，乱换桨会保护停转甚至坠机。
• 禁止超载：最大拉力 ≠ 额定起飞重量。超载会迅速过热坠机。
• 禁止私拆电机、电调，破坏防护。转向看出厂标记，不要对调相线。
• 每次起飞前检查螺钉、电机水平、桨叶完好。
• 降落后面板很烫，不要马上摸。
• 维修只用原厂件。
• 地面测试不要带桨。
            """.trimIndent(),
        ),
        Article(
            id = "siyi-gimbal-io",
            title = "思翼云台接线要点（A8 / ZR10 / MT11）",
            category = "WIRING",
            tags = "SIYI,A8 mini,ZR10,MT11,云台",
            favorite = false,
            createdAt = T0 + 90,
            updatedAt = T0 + 90,
            body = """
控制：S.Bus、UART、以太网 UDP（部分型号 TCP）。视频：A8 有以太网 / HDMI / CVBS；ZR10、MT11 以以太网为主。
电压：A8 / ZR10 现行 11~25.2 V，2023 年 6 月前批次可能更窄，先确认再上 6S。MT11 10~26 V，独立供电。
飞控：ArduPilot / PX4 Mavlink。UART 接 TELEM，TX/RX 交叉。S.Bus 接接收机或链路 S.Bus 出口。
网段：跟思翼链路时按说明书设相机 / 吊舱 IP。倒立、机头模式靠安装姿态自动进入（A8）。
AI 跟踪：A8 / ZR10 为选配模块；MT11 官网写内置约 10T。以对应说明书为准。
            """.trimIndent(),
        ),
        Article(
            id = "skydroid-gcs-tips",
            title = "云卓地面站连接要点",
            category = "WIRING",
            tags = "云卓,Skydroid,G16,G20,H16,H30,QGC",
            favorite = true,
            createdAt = T0 + 90,
            updatedAt = T0 + 90,
            body = """
对频：出厂通常已对好。换机后用助手「对频」。G16：接收机对频键或快开四次，蓝灯快闪，距离约 50 cm。H30：上电约 20 s 可自动连，换机按 SET。
数传：RX 接 TX。波特率与飞控一致，常见 57600 / 115200 / 921600（G16 GR01）。
QGC / 网段
• G16：UDP 监听 14551，服务器 127.0.0.1:14552。相机 192.168.144.x，网关 192.168.144.11。
• H16：UDP 14550（FAQ 也写 14551）。天空端默认 192.168.144.10，地面 192.168.144.11。
• H30：192.168.144.101 端口 14550 / 14551。
图传 RTSP 例
• 思翼/云卓 C10：rtsp://192.168.144.108:554/stream=0
• H16 MIPI/HDMI：rtsp://192.168.0.10:8554/H264Video
FLY：G16 说明书选 S2+G12+G20+G30。S2 飞控只用 FLY，不用 QGC。
热点分享：电脑连遥控器热点后，Mission Planner TCP 常见 192.168.43.1:5760。以本机说明书为准。
            """.trimIndent(),
        ),
        Article(
            id = "um982-f9p-rtk",
            title = "UM982 与 F9P：双天线定向 vs RTK",
            category = "MATCHING",
            tags = "UM982,F9P,ZED-F9P,RTK,定向",
            favorite = true,
            createdAt = T0 + 90,
            updatedAt = T0 + 90,
            body = """
UM982（和芯星通）
单模块双天线：主天线 RTK 定位，从天线定向。1 m 基线约 0.1°（官网 RMS）。20 Hz RTK+Heading。供电 3.0~3.6 V。UART×3。适合要航向、又不想上两套板的多旋翼 / VTOL。

ZED-F9P（u-blox）
单模块单天线，厘米级 RTK（摘要：0.01 m+1 ppm CEP，最高 20 Hz）。本身不算双天线航向。航向：两套 F9P 做 moving base（0xB 支持），或飞控 GPS1+GPS2 yaw。常见 Here3/Here4。供电 2.7~3.6 V。UART 默认多见 38400。Rover 收 RTCM3，Base 可 survey-in。

现场
• 天线远离电调/图传，刚固，同高。基线越长航向越稳。
• 差分链路独立，别和飞控同一条口硬挤。
• 先单点再固定 RTK，看解状态再飞精细航线。
            """.trimIndent(),
        ),
        Article(
            id = "h150-foc-tips",
            title = "H150A FOC：零售款 vs H13MD 套装",
            category = "MATCHING",
            tags = "H150,H150A,H13MD,FOC,电调",
            favorite = true,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
不要把「H150A」当成同一个料。

零售 XRotor Pro H150A 24S FOC（hobbywing.com 独立页）
• 18-24S / 54-104.4 V，持续 50 A，峰值 150 A/3s
• 164×66×38 mm，464 g（不含线），IP55，-20~50℃
• 页写欠压/过压/过流/丢油门保护、故障存储
• DataLinkBox G3，PWM 1100-1940 μs，不可校准

H13MD 套装内 H150A FOC
• 30~130 V（24S/28S 平台），持续 60 A，395 g，132.5×67.5×37.4 mm（带插头）
• 说明书：无低压切断、无过温停转；丢油门立即关输出；过流约 360 A
• 线序跟 H13：PWM 黑/白，CAN 红 CH / 灰 CL

14S 零售款（XRotor H150A 14S FOC）又是另一档：12-14S，持续 60 A，约 198 g。

飞控：PWM 或 CAN 二选一做主油门，双油门可冗余。CAN 500 kbps 常见，ID/通道不重复。ArduPilot 不要做油门行程学习。和 H13MD 共轴一起用时，只信 H13 说明书。
            """.trimIndent(),
        ),
        Article(
            id = "cuav-fc-wiring",
            title = "CUAV 飞控接线要点（X7 / X7 Pro / V6X）",
            category = "WIRING",
            tags = "CUAV,X7,X7 Pro,V6X,CAN,GPS,电流计",
            favorite = true,
            createdAt = T0 + 100,
            updatedAt = T0 + 100,
            body = """
电源
• 飞控只吃 5 V 档电源模块，电池高压先过 PMU。USB 只作地面调试，不带飞。
• X7 / X7 Pro：Power A = 模拟电流计；Power C = DroneCAN 电流计（推荐 CAN PMU）。
• V6X：POWER C1/C2 = DroneCAN（推荐）；POWER1/2 = SMBus/I2C 备份。V1 共 4 个电源口，V2 文档写 2 个。本板默认数字电流计，模拟 ADC 电流计官方写不支持（除非换载板）。

双 CAN
• CAN1 / CAN2 独立。电调、CAN 电流计、CAN GPS 分总线或按电流/长度规划。
• 总线两端各 120 Ω。好盈电调出厂常无终端电阻，要自己补。
• 波特率全员一致，常见 1 M 或 500 k（好盈 H 系列电调常用 500 kbps）。
• 同总线节点 ID 不重复。Hobbywing CAN 油门按电调说明书设通道。

GPS
• GPS1：完整口（含安全开关）。GPS2 / UART4 作第二套或定向从天线。
• UM982 双天线走串口；Here3 等 CAN GPS 走 CAN。天线远离电调/图传。

PWM / 遥控
• 同组 PWM 协议必须相同。X7 族 14 路；V6X 16 路（IO 8 + FMU 8）。
• SBUS/PPM/DSM 可走 RCIN。CRSF / ELRS / 带遥测 FPort 走 UART（X7 常用 SERIAL6=UART7，协议 23），不要插 RCIN 还指望遥测。

固件
• X7 / X7 Pro：ArduPilot CUAV-X7（bdshot 另文件夹）。
• V6X V1：Pixhawk6X / px4_fmu-v6x。V6X V2：CUAV-V6X-v2 / cuav_fmu-v6x。V1/V2 互不兼容。
• 先对板型再写参。以太网只在 V6X：任务机、网口相机走 ETH，飞控 TELEM 仍给数传。
            """.trimIndent(),
        ),
        Article(
            id = "tf02-tf03-compare",
            title = "TF02-Pro vs TF03：定高怎么选",
            category = "MATCHING",
            tags = "北醒,TF02-Pro,TF03,TF03-180,LiDAR",
            favorite = true,
            createdAt = T0 + 110,
            updatedAt = T0 + 110,
            body = """
都是北醒单点 ToF，不是扫描雷达。定高、避障看量程和接口，不要按型号数字硬选。

TF02-Pro（中距）
• 手册 0.1~40 m @90%；10% 反射只到 13.5 m
• UART / I²C / I/O，5~12 V，IP65，约 50 g（含线），FOV 3°
• 定高、植保、车位够用。I²C 可挂多只（改地址）

TF03-100 / TF03-180（长距）
• 180 款 90% 0 klux 到 180 m；强光 10% 只到 50 m
• UART 或 CAN（不能同时），5~24 V，IP67，约 86~92 g，FOV 0.5°
• 需要 CAN、更高防护、更远测距时用。先确认是 100 还是 180

ArduPilot（官网 wiki + 北醒笔记）
• 串口：PROTOCOL=9，115200，TYPE=27（TF02-Pro 与 TF03）
• TF02-Pro I²C：TYPE=25，ADDR=16
• TF03 CAN：PROTOCOL=11，TYPE=34
• MIN/MAX 按可靠读数，Wiki 对 TF02-Pro / TF03 写得比手册满量程保守

安装：镜头干净、目标大于光斑、向下定高 ORIENT=25。雨雾、玻璃、水面、同波长干扰会漂。
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
