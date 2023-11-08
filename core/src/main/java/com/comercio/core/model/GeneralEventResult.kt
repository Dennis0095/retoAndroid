package com.comercio.core.model

import com.comercio.core.util.ConstantCore.ErrorMessage.GENERAL_ERROR_DESCRIPTION
import com.comercio.core.util.ConstantCore.ErrorMessage.GENERAL_ERROR_MESSAGE

sealed class GeneralEventResult {

    object Success : GeneralEventResult()

    data class ErrorGeneral(
        val title: String = GENERAL_ERROR_MESSAGE,
        val message: String = GENERAL_ERROR_DESCRIPTION
    ) : GeneralEventResult()
}
