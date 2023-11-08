package com.comercio.data.core

import com.comercio.core.request_result.RequestResult
import com.comercio.core.util.BaseException
import com.comercio.core.util.ConstantCore.ErrorMessage.UNEXPECTED_PROBLEM
import retrofit2.Response

fun <T, R> Response<T>?.validateResponse(
    transform: T.() -> R,
): RequestResult<R> {
    try {
        this?.let { response ->
            val errorBody: String? = response.errorBody()?.string()
            if (response.isSuccessful && errorBody.isNullOrEmpty()) {
                val responseBody: T? = response.body()
                return responseBody?.let { data ->
                    RequestResult.Success(transform.invoke(data))
                } ?: kotlin.run {
                    RequestResult.Error(BaseException.GeneralException())
                }
            } else {
                if (code() == 401) {
                    return RequestResult.Error(BaseException.GeneralException(code().toString()))
                }
                return RequestResult.Error(BaseException.GeneralException(UNEXPECTED_PROBLEM))
            }
        } ?: kotlin.run {
            return RequestResult.Error(BaseException.GeneralException())
        }
    } catch (ex: Exception) {
        return RequestResult.Error(BaseException.GeneralException())
    }
}