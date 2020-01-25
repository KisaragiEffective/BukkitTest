package com.github.kisaragieffective.bukkittest.org.bukkit.util

import com.github.kisaragieffective.bukkittest.annotations.NoRunningServerTest
import com.github.kisaragieffective.bukkittest.annotations.UndocumentedBehavior
import com.github.kisaragieffective.bukkittest.base.Tester
import org.bukkit.util.NumberConversions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@NoRunningServerTest
@UndocumentedBehavior
object NumberConversionTest : Tester<NumberConversions> {
    @Test
    fun ceilTest() {
        assertEquals(4, NumberConversions.ceil(3.1))
        assertEquals(4, NumberConversions.ceil(3.4))
        assertEquals(4, NumberConversions.ceil(3.5))
        assertEquals(4, NumberConversions.ceil(3.9))
        assertEquals(4, NumberConversions.ceil(4.0))
    }

    @Test
    fun checkDoubleFinite() {
        NumberConversions.checkFinite(Double.MAX_VALUE, "finite")

        NumberConversions.checkFinite(Double.MIN_VALUE, "finite")

        assertThrows<IllegalArgumentException> {
            NumberConversions.checkFinite(Double.NaN, "not finite")
        }

        assertThrows<IllegalArgumentException> {
            NumberConversions.checkFinite(Double.POSITIVE_INFINITY, "should throw")
        }

        assertThrows<IllegalArgumentException> {
            NumberConversions.checkFinite(Double.NEGATIVE_INFINITY, "should throw")
        }
    }

    @Test
    fun checkFloatFinite() {
        NumberConversions.checkFinite(Float.MAX_VALUE, "finite")
        NumberConversions.checkFinite(Float.MIN_VALUE, "finite")

        assertThrows<IllegalArgumentException> {
            NumberConversions.checkFinite(Float.NaN, "not finite")
        }

        assertThrows<IllegalArgumentException> {
            NumberConversions.checkFinite(Float.POSITIVE_INFINITY, "should throw")
        }

        assertThrows<IllegalArgumentException> {
            NumberConversions.checkFinite(Float.NEGATIVE_INFINITY, "should throw")
        }
    }

    @Test
    fun floorTest() {
        assertEquals(3, NumberConversions.floor(3.1))
        assertEquals(3, NumberConversions.floor(3.4))
        assertEquals(3, NumberConversions.floor(3.5))
        assertEquals(3, NumberConversions.floor(3.9))
        assertEquals(4, NumberConversions.floor(4.0))
    }

    @Test
    fun isFloatFinite() {
        assertTrue(NumberConversions.isFinite(Float.MAX_VALUE), "finite")
        assertTrue(NumberConversions.isFinite(Float.MIN_VALUE), "finite")
        assertFalse(NumberConversions.isFinite(Float.NaN), "infinity")
        assertFalse(NumberConversions.isFinite(Float.POSITIVE_INFINITY), "infinity")
        assertFalse(NumberConversions.isFinite(Float.NEGATIVE_INFINITY), "infinity")
    }

    @Test
    fun isDoubleFinite() {
        assertTrue(NumberConversions.isFinite(Double.MAX_VALUE), "finite")
        assertTrue(NumberConversions.isFinite(Double.MIN_VALUE), "finite")
        assertFalse(NumberConversions.isFinite(Double.NaN), "infinity")
        assertFalse(NumberConversions.isFinite(Double.POSITIVE_INFINITY), "infinity")
        assertFalse(NumberConversions.isFinite(Double.NEGATIVE_INFINITY), "infinity")
    }

    @Test
    fun roundTest() {
        assertEquals(3, NumberConversions.round(3.1))
        assertEquals(3, NumberConversions.round(3.4))
        assertEquals(4, NumberConversions.round(3.5))
        assertEquals(4, NumberConversions.round(3.9))
        assertEquals(4, NumberConversions.round(4.0))
    }

    @Test
    fun squareTest() {
        assertEquals(0.0, NumberConversions.square(0.0), "0**2==0")
        assertEquals(1.0, NumberConversions.square(1.0), "1**2==1")
        assertEquals(10000.0, NumberConversions.square(100.0), "100**2==10000")
        assertEquals(Double.POSITIVE_INFINITY, NumberConversions.square(1e308), "1e308**2==+Infinity")
        assertEquals(0.0, NumberConversions.square(-0.0), "-0**2==0")
        assertEquals(1.0, NumberConversions.square(-1.0), "-1**2==1")
        assertEquals(10000.0, NumberConversions.square(-100.0), "-100**2==10000")
        assertEquals(Double.POSITIVE_INFINITY, NumberConversions.square(-1e308), "-1e308**2==+Infinity")
    }

    @Test
    fun toByteTest() {
        // numeric tests
        assertEquals(0, NumberConversions.toByte(0), "0 == 0")
        assertEquals(127, NumberConversions.toByte(127), "127 == 127")
        assertEquals(-128, NumberConversions.toByte(128))
        assertEquals(-1, NumberConversions.toByte(255))
        assertEquals(0, NumberConversions.toByte(256))

        // string tests
        assertEquals(0, NumberConversions.toByte("0"), "0 == 0")
        assertEquals(127, NumberConversions.toByte("127"), "127 == 127")
    }

    @Test
    fun toDoubleTest() {
        TODO()
    }

    @Test
    fun toFloatTest() {
        TODO()
    }

    @Test
    fun toIntTest() {
        TODO()
    }

    @Test
    fun toLongTest() {
        TODO()
    }

    @Test
    fun toShortTest() {
        TODO()
    }
}
