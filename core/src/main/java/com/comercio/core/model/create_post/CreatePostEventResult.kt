package com.comercio.core.model.create_post

import com.comercio.core.util.ConstantCore

sealed class CreatePostEventResult{

    data class Success(val data: CreatePostResponse) : CreatePostEventResult()

    data class ErrorGeneral(
        val title: String = ConstantCore.ErrorMessage.GENERAL_ERROR_MESSAGE,
        val message: String = ConstantCore.ErrorMessage.GENERAL_ERROR_DESCRIPTION
    ) : CreatePostEventResult()
}
