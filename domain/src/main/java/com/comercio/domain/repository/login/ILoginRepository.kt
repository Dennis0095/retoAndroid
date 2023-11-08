package com.comercio.domain.repository.login

import com.comercio.core.model.login.LoginRequest
import com.comercio.core.model.login.LoginResponse
import com.comercio.core.request_result.RequestResult

interface ILoginRepository {

    suspend fun login(loginRequest: LoginRequest): RequestResult<LoginResponse>

}