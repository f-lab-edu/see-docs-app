package kr.co.testing.util

import junit.framework.TestCase.assertEquals

fun asserts(vararg value: Boolean) =
    value.forEach {
        assert(it)
    }

fun assertsEquals(vararg value: Pair<Any?, Any?>) =
    value.forEach { (a, b) ->
        assertEquals(a, b)
    }