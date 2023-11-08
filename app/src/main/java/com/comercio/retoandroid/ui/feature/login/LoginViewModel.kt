package com.comercio.retoandroid.ui.feature.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comercio.core.model.login.LoginRequest
import com.comercio.core.util.ConstantCore.BaseUrl.URL_COMERCIO
import com.comercio.domain.interactor.login.LoginUseCase
import com.comercio.retoandroid.commons.core.launchOnIO
import com.comercio.retoandroid.di.NetWorkModule
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents> = _events


    fun login() {
        launchOnIO(
            doTask = {
                loginUseCase.login(
                    LoginRequest(
                        email = _state.value.email,
                        password = _state.value.password
                    )
                )
            },
            result = {
                NetWorkModule.updateBaseUrl(URL_COMERCIO)
                viewModelScope.launch {
                    _events.emit(
                        UIEvents.GoUsers
                    )
                }
            },
            error = {
                viewModelScope.launch {
                    _events.emit(
                        UIEvents.ErrorService
                    )
                }
            }
        )
    }

    fun updateEmail(newEmail: String) {
        _state.value = state.value.copy(
            email = newEmail
        )
    }

    fun updatePassword(newPassword: String) {
        _state.value = state.value.copy(
            password = newPassword
        )
    }

    sealed class UIEvents {
        object GoUsers : UIEvents()
        object ErrorService : UIEvents()
    }
}