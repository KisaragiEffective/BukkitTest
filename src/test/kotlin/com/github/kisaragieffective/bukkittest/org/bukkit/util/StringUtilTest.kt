package com.github.kisaragieffective.bukkittest.org.bukkit.util

import com.github.kisaragieffective.bukkittest.annotations.NoRunningServerTest
import com.github.kisaragieffective.bukkittest.base.Tester
import org.bukkit.util.StringUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@NoRunningServerTest
object StringUtilTest : Tester<StringUtil> {
    @Test
    fun startsWithIgnoreCaseTest() {
        assert(StringUtil.startsWithIgnoreCase("1234567890", "1234567890"))
        assert(StringUtil.startsWithIgnoreCase("AbCdEfGhIjKlMnOpQrStUvWxYz", "aBcDeFgHiJkLmNoPqRsTuVwXyZ"))
    }

    @Test
    fun copyPartialMatchesTest() {
        assertThrows<IllegalArgumentException> {
            StringUtil.copyPartialMatches(null, emptyList(), mutableListOf<String>())
        }

        assertThrows<IllegalArgumentException> {
            StringUtil.copyPartialMatches("", null, mutableListOf<String>())
        }

        assertThrows<IllegalArgumentException> {
            StringUtil.copyPartialMatches("", emptyList(), null)
        }

        run {
            val list = mutableListOf("abc", "abcdef", "ghij", "kmln", "ghijkmln", "xyzabc")
            assertTrue {
                val into = mutableListOf<String>()
                StringUtil.copyPartialMatches("abc", list, into)
                into == mutableListOf("abc", "abcdef")
            }

            assertFalse {
                val into = mutableListOf<String>()
                StringUtil.copyPartialMatches("abc", list, into)
                into == mutableListOf("abc", "abcdef", "xyzabc")
            }

            assertFalse {
                val into = mutableListOf<String>()
                StringUtil.copyPartialMatches("mln", list, into)
                into == mutableListOf("kmln", "ghijkmln")
            }

            assertTrue {
                val into = mutableListOf<String>()
                StringUtil.copyPartialMatches("", list, into)
                into == list
            }
        }
    }
}