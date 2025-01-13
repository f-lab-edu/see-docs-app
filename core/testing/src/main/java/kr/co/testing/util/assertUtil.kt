package kr.co.testing.util

fun asserts(vararg value: Boolean) =
    value.forEach {
        assert(it)
    }