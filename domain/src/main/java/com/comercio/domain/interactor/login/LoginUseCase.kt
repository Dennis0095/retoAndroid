package com.comercio.domain.interactor.login

import com.comercio.core.model.login.LoginRequest
import com.comercio.core.model.login.LoginResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.domain.repository.login.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: ILoginRepository
) {
    suspend fun login(loginRequest: LoginRequest): RequestResult<LoginResponse> {
        return loginRepository.login(loginRequest)
    }
}