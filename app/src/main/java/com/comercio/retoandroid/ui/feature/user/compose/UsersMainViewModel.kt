package com.comercio.retoandroid.ui.feature.user.compose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comercio.core.model.create_post.CreatePost
import com.comercio.domain.interactor.user.CreatePostUseCase
import com.comercio.domain.interactor.user.GetPostsUseCase
import com.comercio.domain.interactor.user.GetUserUseCase
import com.comercio.retoandroid.commons.core.launchOnIO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersMainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val createPostUseCase: CreatePostUseCase,
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    private var _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents> = _events


    fun getUsers() {
        launchOnIO(
            doTask = {
                getUserUseCase.getUsers()
            },
            result = {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        listsUsers = it
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

    fun createPost(createPost: CreatePost) {
        launchOnIO(
            doTask = {
                createPostUseCase.createPost(createPost)
            },
            result = {
                viewModelScope.launch {
                    val listNewPosts = _state.value.listPosts
                    listNewPosts.add(0, it)
                    _state.value = state.value.copy(
                        listPosts = listNewPosts
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

    fun getPosts() {
        launchOnIO(
            doTask = {
                getPostsUseCase.getPosts()
            },
            result = {

                viewModelScope.launch {
                    _state.value = state.value.copy(
                        listPosts = it
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

    sealed class UIEvents {
        object ErrorService : UIEvents()
    }
}