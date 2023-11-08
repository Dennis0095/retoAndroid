package com.comercio.data.network.service.login

import com.comercio.core.model.login.LoginRequest
import com.comercio.core.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}