package com.comercio.core.util

import com.comercio.core.util.ConstantCore.ErrorMessage.GENERAL_ERROR_MESSAGE
import java.io.IOException

sealed class BaseException (errorMessage: String)
    : IOException(errorMessage){

    data class GeneralException(
        var errorMessage: String = GENERAL_ERROR_MESSAGE,
    ) : BaseException(errorMessage)

}