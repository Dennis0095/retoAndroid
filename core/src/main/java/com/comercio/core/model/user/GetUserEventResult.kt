package com.comercio.core.model.user

import com.comercio.core.model.User

sealed class GetUserEventResult {
    data class ShowUsers(val data: ArrayList<User>) : GetUserEventResult()

    object UsersEmpty : GetUserEventResult()
}
