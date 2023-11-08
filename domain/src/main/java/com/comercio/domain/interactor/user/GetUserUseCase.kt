package com.comercio.domain.interactor.user

import com.comercio.core.model.User
import com.comercio.core.request_result.RequestResult
import com.comercio.domain.repository.user.IUserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {
    suspend fun getUsers(): RequestResult<ArrayList<User>> {
        return userRepository.getUsers()
    }
}