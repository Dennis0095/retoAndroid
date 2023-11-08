package com.comercio.core.model.get_posts

import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.util.ConstantCore

sealed class GetPostsEventResult{
    data class Success(val data: ArrayList<CreatePostResponse>): GetPostsEventResult()

    data class ErrorGeneral(
        val title: String = ConstantCore.ErrorMessage.GENERAL_ERROR_MESSAGE,
        val message: String = ConstantCore.ErrorMessage.GENERAL_ERROR_DESCRIPTION
    ) : GetPostsEventResult()
}
