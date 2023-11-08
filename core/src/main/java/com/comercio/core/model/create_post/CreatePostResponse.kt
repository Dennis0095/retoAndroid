package com.comercio.core.model.create_post

data class CreatePostResponse(
    val title: String,
    val body: String,
    val userId: Int,
    val id: Int
)
