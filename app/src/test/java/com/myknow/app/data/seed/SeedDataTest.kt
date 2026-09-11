package com.myknow.app.data.seed

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SeedDataTest {
    @Test
    fun includesHobbywingH15Plus() {
        val kit = SeedData.devices().first { it.id == "hobbywing-h15md-plus" }
        assertTrue(kit.model.contains("H15"))
        assertTrue(kit.notes.contains("80 kg"))
        assertTrue(kit.specsJson.contains("H15MD Plus-24S"))
        assertTrue(SeedData.articles().any { it.title.contains("接线") })
    }

    @Test
    fun includesHobbywingH13MD() {
        val kit = SeedData.devices().first { it.id == "hobbywing-h13md" }
        assertTrue(kit.favorite)
        assertTrue(kit.model.contains("H13"))
        assertTrue(kit.tags.contains("H13"))
        assertTrue(kit.tags.contains("H13MD"))
        assertTrue(kit.notes.contains("45 kg"))
        assertTrue(kit.notes.contains("12AWG"))
        assertTrue(kit.notes.contains("60 mm"))
        assertTrue(kit.notes.contains("IP35"))
        assertTrue(kit.specsJson.contains("H13MD"))
        assertTrue(kit.notes.contains("H150A"))
        assertFalse(kit.notes.contains("7AWG"))
        assertFalse(kit.notes.contains("Ø80"))

        val ids = SeedData.devices().map { it.id }
        assertTrue(ids.contains("hobbywing-h13md-esc"))
        assertTrue(ids.contains("hobbywing-h13md-motor"))
        assertTrue(ids.contains("hobbywing-msc-54x20"))
        assertTrue(ids.contains("hobbywing-msc-57x20"))

        val articleIds = SeedData.articles().map { it.id }
        assertTrue(articleIds.contains("h13-wiring"))
        assertTrue(articleIds.contains("h13-install"))
        assertTrue(articleIds.contains("h13-protect"))
        assertTrue(articleIds.contains("h13-thrust"))
        assertTrue(articleIds.contains("h13-caution"))
        assertTrue(SeedData.articles().any { it.id == "h13-wiring" && it.tags.contains("H13MD") })

        val esc = SeedData.devices().first { it.id == "hobbywing-h13md-esc" }
        assertTrue(esc.notes.contains("60 A"))
        assertTrue(esc.notes.contains("150 A"))
        assertTrue(esc.notes.contains("360 A"))
        assertFalse(esc.notes.contains("110 A"))
        assertFalse(esc.notes.contains("800 A"))
    }

    @Test
    fun includesSiyiSkydroidGnss() {
        val ids = SeedData.devices().map { it.id }
        assertTrue(ids.contains("siyi-a8-mini"))
        assertTrue(ids.contains("siyi-zr10"))
        assertTrue(ids.contains("siyi-unirc-7"))
        assertTrue(ids.contains("siyi-unirc-10-pro"))
        assertTrue(ids.contains("siyi-unipod-mt11"))
        assertTrue(ids.contains("skydroid-g16"))
        assertTrue(ids.contains("skydroid-g20"))
        assertTrue(ids.contains("skydroid-h16"))
        assertTrue(ids.contains("skydroid-h30"))
        assertTrue(ids.contains("unicore-um982"))
        assertTrue(ids.contains("ublox-zed-f9p"))

        val zr10 = SeedData.devices().first { it.id == "siyi-zr10" }
        assertTrue(zr10.tags.contains("AR10"))
        assertTrue(zr10.notes.contains("ZR10"))
        assertTrue(zr10.type == "CAMERA")

        val um982 = SeedData.devices().first { it.id == "unicore-um982" }
        assertTrue(um982.type == "GPS")
        assertTrue(um982.notes.contains("0.8 cm"))
        assertTrue(um982.notes.contains("双天线"))

        val f9p = SeedData.devices().first { it.id == "ublox-zed-f9p" }
        assertTrue(f9p.type == "GPS")
        assertTrue(f9p.notes.contains("单天线"))
        assertTrue(f9p.notes.contains("2.7~3.6"))
        assertTrue(f9p.tags.contains("F9P"))

        val articleIds = SeedData.articles().map { it.id }
        assertTrue(articleIds.contains("skydroid-gcs-tips"))
        assertTrue(articleIds.contains("um982-f9p-rtk"))
        assertTrue(articleIds.contains("siyi-gimbal-io"))
    }

    @Test
    fun includesHobbywingH150Esc() {
        val esc = SeedData.devices().first { it.id == "hobbywing-h150a-foc" }
        assertTrue(esc.type == "ESC")
        assertTrue(esc.favorite)
        assertTrue(esc.model.contains("H150A"))
        assertTrue(esc.tags.contains("H150"))
        assertTrue(esc.tags.contains("H150A"))
        assertTrue(esc.notes.contains("XRotor Pro H150A 24S FOC"))
        assertTrue(esc.notes.contains("18-24S"))
        assertTrue(esc.notes.contains("50 A"))
        assertTrue(esc.notes.contains("464"))
        assertTrue(esc.notes.contains("164×66×38"))
        assertTrue(esc.notes.contains("DataLinkBox G3"))
        assertTrue(esc.notes.contains("H13MD"))
        assertTrue(esc.specsJson.contains("XRotor Pro H150A 24S FOC"))
        assertFalse(esc.notes.contains("36~130"))

        val kitEsc = SeedData.devices().first { it.id == "hobbywing-h13md-esc" }
        assertTrue(kitEsc.notes.contains("XRotor Pro H150A 24S FOC"))
        assertTrue(kitEsc.notes.contains("60 A"))
        assertFalse(kitEsc.notes.contains("50 A（散热良好）"))

        assertTrue(SeedData.articles().any { it.id == "h150-foc-tips" && it.tags.contains("H150") })
    }

    @Test
    fun includesCuavFlightControllers() {
        val ids = SeedData.devices().map { it.id }
        assertTrue(ids.contains("cuav-x7"))
        assertTrue(ids.contains("cuav-x7-pro"))
        assertTrue(ids.contains("cuav-v6x"))

        val x7 = SeedData.devices().first { it.id == "cuav-x7" }
        assertTrue(x7.type == "FLIGHT_CONTROLLER")
        assertTrue(x7.notes.contains("STM32H743"))
        assertTrue(x7.notes.contains("BMI088"))
        assertTrue(x7.notes.contains("ICM-20649"))
        assertTrue(x7.specsJson.contains("STM32H743"))
        assertFalse(x7.notes.contains("ADIS16470"))

        val pro = SeedData.devices().first { it.id == "cuav-x7-pro" }
        assertTrue(pro.type == "FLIGHT_CONTROLLER")
        assertTrue(pro.notes.contains("ADIS16470"))
        assertTrue(pro.notes.contains("X7+ Pro"))
        assertTrue(pro.tags.contains("X7 Pro"))

        val v6x = SeedData.devices().first { it.id == "cuav-v6x" }
        assertTrue(v6x.type == "FLIGHT_CONTROLLER")
        assertTrue(v6x.notes.contains("STM32H753"))
        assertTrue(v6x.notes.contains("FMUv6X"))
        assertTrue(v6x.notes.contains("100"))
        assertTrue(v6x.notes.contains("以太网") || v6x.specsJson.contains("100 Mbps"))
        assertTrue(v6x.notes.contains("CUAV-V6X-v2") || v6x.notes.contains("Pixhawk6X"))

        val articleIds = SeedData.articles().map { it.id }
        assertTrue(articleIds.contains("cuav-fc-wiring"))
        assertTrue(SeedData.articles().any { it.id == "cuav-fc-wiring" && it.tags.contains("V6X") })
    }

    @Test
    fun includesBenewakeLidars() {
        val ids = SeedData.devices().map { it.id }
        assertTrue(ids.contains("benewake-tf02-pro"))
        assertTrue(ids.contains("benewake-tf03"))

        val tf02 = SeedData.devices().first { it.id == "benewake-tf02-pro" }
        assertTrue(tf02.type == "OTHER")
        assertTrue(tf02.brand.contains("北醒"))
        assertTrue(tf02.model.contains("TF02-Pro"))
        assertTrue(tf02.tags.contains("TF02-Pro"))
        assertTrue(tf02.notes.contains("0.1~40"))
        assertTrue(tf02.notes.contains("13.5"))
        assertTrue(tf02.notes.contains("UART"))
        assertTrue(tf02.notes.contains("I²C") || tf02.notes.contains("I2C"))
        assertTrue(tf02.specsJson.contains("IP65"))
        assertTrue(tf02.specsJson.contains("5~12"))
        assertFalse(tf02.notes.contains("180 m"))

        val tf03 = SeedData.devices().first { it.id == "benewake-tf03" }
        assertTrue(tf03.type == "OTHER")
        assertTrue(tf03.model.contains("TF03"))
        assertTrue(tf03.tags.contains("TF03-180"))
        assertTrue(tf03.notes.contains("TF03-100"))
        assertTrue(tf03.notes.contains("TF03-180"))
        assertTrue(tf03.notes.contains("UART"))
        assertTrue(tf03.notes.contains("CAN"))
        assertTrue(tf03.notes.contains("IP67"))
        assertTrue(tf03.specsJson.contains("5~24"))
        assertTrue(tf03.specsJson.contains("180"))

        val article = SeedData.articles().first { it.id == "tf02-tf03-compare" }
        assertTrue(article.tags.contains("TF02-Pro"))
        assertTrue(article.tags.contains("TF03"))
        assertTrue(article.body.contains("TYPE=27"))
    }
}
