package com.comercio.data.network.service.user

import com.comercio.core.model.User
import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.data.core.validateResponse
import javax.inject.Inject

class UserService @Inject constructor(
    private val restApi: IUserService
) {
    suspend fun getUsers(): RequestResult<ArrayList<User>> {
        return restApi.getUsers().validateResponse { this }
    }

    suspend fun createPost(createPost: CreatePost): RequestResult<CreatePostResponse> {
        return restApi.createPost(createPost).validateResponse { this }
    }

    suspend fun getPosts(): RequestResult<ArrayList<CreatePostResponse>> {
        return restApi.getPosts().validateResponse { this }
    }


}