package kr.co.common.model

sealed interface CommonError {
    data object Unknown: CommonError
    data object PoorNetwork: CommonError
    data object NoNetwork: CommonError
    data object UnAuthorized: CommonError
}