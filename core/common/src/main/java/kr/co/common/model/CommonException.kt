package kr.co.common.model

import java.io.IOException

class CommonException @JvmOverloads constructor(
    val error: CommonError = CommonError.Unknown,
    message: String? = null,
    cause: Throwable? = null,
    val code: Int? = null,
) : IOException(null, cause) {
    override val message: String = message ?: "error=${cause?.localizedMessage}:code=${code}"

    override fun toString(): String {
        return "CommonException(error=$error: medssage=$message: code=$code"
    }

    companion object {
        val illegalStateException = IllegalStateException().let {
            CommonException(
                error = CommonError.Unknown,
                message = it.message,
                cause = it,
            )
        }
    }
}