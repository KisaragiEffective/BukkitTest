package com.github.kisaragieffective.bukkittest.org.bukkit.util

import com.github.kisaragieffective.bukkittest.annotations.NoRunningServerTest
import com.github.kisaragieffective.bukkittest.base.Tester
import org.bukkit.util.EulerAngle
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

@NoRunningServerTest
object EulerAngleTest : Tester<EulerAngle> {
    @Test
    fun subtractTest() {
        val zero = EulerAngle.ZERO
        val res = zero.subtract(16.0, 0.0, -32.0)
        assertTrue {
            res.x == -16.0
        }

        assertTrue {
            res.y == 0.0
        }

        assertTrue {
            res.z == 32.0
        }
    }

    @Test
    fun addTest() {
        val zero = EulerAngle.ZERO
        val res = zero.add(16.0, 0.0, -32.0)
        assertTrue {
            res.x == 16.0
        }

        assertTrue {
            res.y == 0.0
        }

        assertTrue {
            res.z == -32.0
        }
    }
}