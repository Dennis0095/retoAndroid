package com.comercio.retoandroid.ui.feature.user.compose

import com.comercio.core.model.User
import com.comercio.core.model.create_post.CreatePostResponse

data class UsersState(
    val listPosts : ArrayList<CreatePostResponse> = arrayListOf(),
    val listsUsers : ArrayList<User> = arrayListOf()
)
