package com.comercio.retoandroid.ui.feature.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostEventResult
import com.comercio.core.model.get_posts.GetPostsEventResult
import com.comercio.core.model.user.GetUserEventResult
import com.comercio.domain.interactor.user.CreatePostUseCase
import com.comercio.domain.interactor.user.GetPostsUseCase
import com.comercio.domain.interactor.user.GetUserUseCase
import com.comercio.retoandroid.commons.core.launchOnIO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val createPostUseCase: CreatePostUseCase,
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    val usersViewModel = MutableLiveData<GetUserEventResult>()
    val createPostViewModel = MutableLiveData<CreatePostEventResult>()
    val getPostsViewModel = MutableLiveData<GetPostsEventResult>()

    fun getUsers() {
        launchOnIO(
            doTask = {
                getUserUseCase.getUsers()
            },
            result = {
                usersViewModel.postValue(GetUserEventResult.ShowUsers(it))
            },
            error = {
                usersViewModel.postValue(GetUserEventResult.UsersEmpty)
            }
        )
    }

    fun createPost(createPost: CreatePost) {
        launchOnIO(
            doTask = {
                createPostUseCase.createPost(createPost)
            },
            result = {
                createPostViewModel.postValue(CreatePostEventResult.Success(it))
            },
            error = {
                createPostViewModel.postValue(CreatePostEventResult.ErrorGeneral())
            }
        )
    }

    fun getPosts() {
        launchOnIO(
            doTask = {
                getPostsUseCase.getPosts()
            },
            result = {
                getPostsViewModel.postValue(GetPostsEventResult.Success(it))
            },
            error = {
                getPostsViewModel.postValue(GetPostsEventResult.ErrorGeneral())
            }
        )
    }


}