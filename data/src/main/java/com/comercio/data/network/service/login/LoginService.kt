package com.comercio.data.network.service.login

import com.comercio.core.model.login.LoginRequest
import com.comercio.core.model.login.LoginResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.data.core.validateResponse
import javax.inject.Inject

class LoginService @Inject constructor(
    private val restApi: ILoginService
) {
    suspend fun login(loginRequest: LoginRequest): RequestResult<LoginResponse> {
        return restApi.login(loginRequest).validateResponse { this }
    }
}