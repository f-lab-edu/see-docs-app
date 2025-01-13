package kr.co.testing.util

import app.cash.turbine.test
import kotlinx.coroutines.flow.Flow
import kotlin.time.Duration

suspend fun <T> Flow<T>.testWithItem(
    timeout: Duration? = null,
    name: String? = null,
    action: suspend (T) -> Unit,
) =
    test(timeout, name) {
        awaitItem().also {
            action(it)
            cancelAndConsumeRemainingEvents()
        }
    }