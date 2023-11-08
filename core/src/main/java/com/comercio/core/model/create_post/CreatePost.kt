package com.comercio.core.model.create_post

data class CreatePost(
    val title: String,
    val body: String,
    val userId: Int = 1
)
