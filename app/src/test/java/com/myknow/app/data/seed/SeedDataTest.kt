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
}
