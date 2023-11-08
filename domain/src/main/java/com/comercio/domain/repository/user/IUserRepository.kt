package com.comercio.domain.repository.user

import com.comercio.core.model.User
import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.request_result.RequestResult

interface IUserRepository {

    suspend fun getUsers(): RequestResult<ArrayList<User>>

    suspend fun getPosts(): RequestResult<ArrayList<CreatePostResponse>>

    suspend fun createPost(createPost: CreatePost): RequestResult<CreatePostResponse>

}