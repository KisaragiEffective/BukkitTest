package com.github.kisaragieffective.bukkittest.org.bukkit.util

import com.github.kisaragieffective.bukkittest.annotations.NoRunningServerTest
import com.github.kisaragieffective.bukkittest.base.Tester
import org.bukkit.util.BlockVector
import org.bukkit.util.Vector
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@NoRunningServerTest
object BlockVectorTest : Tester<BlockVector> {
    @Test
    fun equalTest() {
        val (x1, y1, z1) = BlockVector(3, 4, 2)
        val (x2, y2, z2) = BlockVector(3, 4, 2)

        assertEquals(x1, x2)
        assertEquals(y1, y2)
        assertEquals(z1, z2)
    }

    private operator fun Vector.component1() = x
    private operator fun Vector.component2() = y
    private operator fun Vector.component3() = z
}

