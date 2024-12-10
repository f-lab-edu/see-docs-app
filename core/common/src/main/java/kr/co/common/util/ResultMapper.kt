package kr.co.common.util

import kr.co.common.model.CommonException
import kr.co.common.model.CommonResult
import kr.co.common.model.getOrThrow

abstract class ResultMapper<LEFT, RIGHT> : Mapper<LEFT,RIGHT> {

    fun convert(result: CommonResult<LEFT>): CommonResult<RIGHT> =
        if (result.isSuccess) {
            CommonResult.success(invoke(result.getOrThrow()))
        } else {
            CommonResult.failure(result.exceptionOrNull()?: CommonException.illegalStateException)
        }
}