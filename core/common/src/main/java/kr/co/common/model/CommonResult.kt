package kr.co.common.model

import java.io.Serializable
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@JvmInline
value class CommonResult<out T> internal constructor(
    @PublishedApi
    internal val value: Any?
) : Serializable {
    val isSuccess: Boolean get() = value !is Failure

    val isFailure: Boolean get() = value is Failure

    fun getOrNull(): T? =
        when {
            isFailure -> null
            else -> value as T
        }

    override fun toString(): String =
        when (value) {
            is Failure -> value.toString()
            else -> "Success($value)"
        }

    fun exceptionOrNull(): CommonException? =
        when (value) {
            is Failure -> value.exception
            else -> null
        }

    fun toUnit(): CommonResult<Unit> =
        when (value) {
            is Failure -> CommonResult(value)
            else -> CommonResult(Unit)
        }

    companion object {
        fun <T> success(value: T): CommonResult<T> =
            CommonResult(value)

        fun <T> failure(exception: CommonException): CommonResult<T> =
            CommonResult(Failure(exception))
    }

    internal class Failure(
        @JvmField
        val exception: CommonException
    ) : Serializable {
        override fun equals(other: Any?): Boolean = other is Failure && exception == other.exception
        override fun hashCode(): Int = exception.hashCode()
        override fun toString(): String = "Failure($exception)"
    }
}

@PublishedApi
internal fun CommonResult<*>.throwOnFailure() {
    if (value is CommonResult.Failure) throw value.exception
}

fun <T> CommonResult<T>.getOrThrow(): T {
    throwOnFailure()
    return value as T
}


inline fun <R> commonRunCatching(block: () -> R): CommonResult<R> {
    return try {
        CommonResult.success(block())
    } catch (e: CommonException) {
        CommonResult.failure(e)
    }
}


@OptIn(ExperimentalContracts::class)
inline fun <T> CommonResult<T>.onSuccess(action: (value: T) -> Unit): CommonResult<T> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    if (isSuccess) action(value as T)
    return this
}

@OptIn(ExperimentalContracts::class)
inline fun <T> CommonResult<T>.onFailure(action: (exception: CommonException) -> Unit): CommonResult<T> {
    contract {
        callsInPlace(action, InvocationKind.AT_MOST_ONCE)
    }
    exceptionOrNull()?.let { action(it) }
    return this
}