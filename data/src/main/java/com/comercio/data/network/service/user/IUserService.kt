package com.comercio.data.network.service.user

import com.comercio.core.model.User
import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IUserService {

    @GET("users")
    suspend fun getUsers(): Response<ArrayList<User>>

    @GET("users/1/posts")
    suspend fun getPosts(): Response<ArrayList<CreatePostResponse>>

    @POST("posts")
    suspend fun createPost(@Body createPost: CreatePost): Response<CreatePostResponse>


}