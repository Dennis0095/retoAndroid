package com.comercio.domain.interactor.login

import com.comercio.core.model.login.LoginRequest
import com.comercio.core.model.login.LoginResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.domain.repository.login.ILoginRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoginUseCaseTest{

    @RelaxedMockK
    private lateinit var repo: ILoginRepository

    lateinit var loginUseCase: LoginUseCase

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        loginUseCase = LoginUseCase(repo)
    }

    @Test
    fun login() = runBlocking{
        val loginResponse = LoginResponse(code = "", message = "")
        val loginRequest = LoginRequest(email = "dnrich95@gmail.com", password = "pwd129")
        coEvery {
            repo.login(loginRequest)
        }returns RequestResult.Success(loginResponse)

        val result = loginUseCase.login(loginRequest)

        coVerify (exactly = 1){ repo.login(loginRequest) }

        if(result is RequestResult.Success){
            assert(true)
        }
    }
}