package com.myknow.app.data.seed

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
}
