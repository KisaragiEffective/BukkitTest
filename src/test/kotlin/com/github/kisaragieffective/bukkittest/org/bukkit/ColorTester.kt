package com.github.kisaragieffective.bukkittest.org.bukkit

import com.github.kisaragieffective.bukkittest.annotations.NoRunningServerTest
import com.github.kisaragieffective.bukkittest.base.Tester
import org.bukkit.Color
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

@NoRunningServerTest
object ColorTester : Tester<Color> {
    @Test
    fun builtinStaticsTest() {
        // fromRGB(i24)
        assertEquals(Color.fromRGB(0x00FFFF), Color.AQUA)
        assertEquals(Color.fromRGB(0x000000), Color.BLACK)
        assertEquals(Color.fromRGB(0x0000FF), Color.BLUE)
        assertEquals(Color.fromRGB(0xFF00FF), Color.FUCHSIA)
        assertEquals(Color.fromRGB(0x808080), Color.GRAY)
        assertEquals(Color.fromRGB(0x008000), Color.GREEN)
        assertEquals(Color.fromRGB(0x00FF00), Color.LIME)
        assertEquals(Color.fromRGB(0x800000), Color.MAROON)
        assertEquals(Color.fromRGB(0x000080), Color.NAVY)
        assertEquals(Color.fromRGB(0x808000), Color.OLIVE)
        assertEquals(Color.fromRGB(0xFFA500), Color.ORANGE)
        assertEquals(Color.fromRGB(0x800080), Color.PURPLE)
        assertEquals(Color.fromRGB(0xFF0000), Color.RED)
        assertEquals(Color.fromRGB(0xC0C0C0), Color.SILVER)
        assertEquals(Color.fromRGB(0x008080), Color.TEAL)
        assertEquals(Color.fromRGB(0xFFFFFF), Color.WHITE)
        assertEquals(Color.fromRGB(0xFFFF00), Color.YELLOW)
    }

    @Test
    fun setBlueTest() {
        assertEquals(Color.fromRGB(0xFFFF00), Color.WHITE.setBlue(0))
    }

    @Test
    fun setRedTest() {
        assertEquals(Color.fromRGB(0x00FFFF), Color.WHITE.setRed(0))
    }

    @Test
    fun setGreenTest() {
        assertEquals(Color.fromRGB(0xFF00FF), Color.WHITE.setGreen(0))
    }

    @Test
    fun bgrTest() {
        assertEquals(Color.fromBGR(0x808000), Color.TEAL)
    }

    @Test
    fun mixColorTest() {
        assertThrows<IllegalArgumentException> {
            Color.WHITE.mixColors(null)
        }

        run {
            val mixed = Color.WHITE.mixColors(Color.RED, Color.GREEN, Color.BLUE)
            assertEquals(Color.fromRGB(0xDFA6DF), mixed, "Oof: $mixed")
        }
    }
}