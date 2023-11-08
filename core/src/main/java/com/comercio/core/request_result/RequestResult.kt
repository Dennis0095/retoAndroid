package com.comercio.core.request_result

sealed class RequestResult<T>{

    data class Success<T>(val value: T) : RequestResult<T>()

    data class Error<T>(val exception: Exception) : RequestResult<T>()
}
