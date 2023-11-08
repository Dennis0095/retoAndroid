package com.comercio.data.repository.user

import com.comercio.core.model.User
import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.data.network.service.user.UserService
import com.comercio.domain.repository.user.IUserRepository
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val api: UserService
) : IUserRepository {

    override suspend fun getUsers(): RequestResult<ArrayList<User>> {
        return when (val response = api.getUsers()) {
            is RequestResult.Success -> {
                RequestResult.Success(response.value)
            }
            is RequestResult.Error -> {
                RequestResult.Error(response.exception)
            }
        }
    }

    override suspend fun getPosts(): RequestResult<ArrayList<CreatePostResponse>> {
        return when (val response = api.getPosts()) {
            is RequestResult.Success -> {
                RequestResult.Success(response.value)
            }
            is RequestResult.Error -> {
                RequestResult.Error(response.exception)
            }
        }
    }

    override suspend fun createPost(createPost: CreatePost): RequestResult<CreatePostResponse> {
        return when (val response = api.createPost(createPost)) {
            is RequestResult.Success -> {
                RequestResult.Success(response.value)
            }
            is RequestResult.Error -> {
                RequestResult.Error(response.exception)
            }
        }
    }
}