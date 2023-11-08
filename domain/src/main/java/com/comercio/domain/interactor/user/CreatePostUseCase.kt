package com.comercio.domain.interactor.user

import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.domain.repository.user.IUserRepository
import javax.inject.Inject

class CreatePostUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {
    suspend fun createPost(createPost: CreatePost): RequestResult<CreatePostResponse> {
        return userRepository.createPost(createPost)
    }
}