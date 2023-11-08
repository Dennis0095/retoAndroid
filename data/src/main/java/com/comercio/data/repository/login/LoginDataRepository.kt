package com.comercio.data.repository.login

import com.comercio.core.model.login.LoginRequest
import com.comercio.core.model.login.LoginResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.data.network.service.login.LoginService
import com.comercio.domain.repository.login.ILoginRepository
import javax.inject.Inject

class LoginDataRepository @Inject constructor(
    private val api: LoginService
) : ILoginRepository {
    override suspend fun login(loginRequest: LoginRequest): RequestResult<LoginResponse> {
        return when (val response = api.login(loginRequest)) {
            is RequestResult.Success -> {
                RequestResult.Success(response.value)
            }
            is RequestResult.Error -> {
                RequestResult.Error(response.exception)
            }
        }
    }
}