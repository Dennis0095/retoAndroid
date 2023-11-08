package com.comercio.domain.interactor.user

import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.domain.repository.user.IUserRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {
    suspend fun getPosts(): RequestResult<ArrayList<CreatePostResponse>> {
        return userRepository.getPosts()
    }
}