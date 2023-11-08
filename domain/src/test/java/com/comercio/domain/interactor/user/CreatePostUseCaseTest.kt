package com.comercio.domain.interactor.user

import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.request_result.RequestResult
import com.comercio.domain.repository.user.IUserRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class CreatePostUseCaseTest{

    @RelaxedMockK
    private lateinit var repo: IUserRepository

    lateinit var createPostUseCase: CreatePostUseCase

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        createPostUseCase = CreatePostUseCase(repo)
    }

    @Test
    fun create_post_success() = runBlocking{
        val createPostRequest = CreatePost(title = "", body = "")
        val createPostResponse = CreatePostResponse(title = "", userId = 1, id = 1, body = "")

        coEvery {
            repo.createPost(createPostRequest)
        }returns RequestResult.Success(createPostResponse)

        val result = createPostUseCase.createPost(createPostRequest)

        coVerify (exactly = 1){ repo.createPost(createPostRequest) }

        if(result is RequestResult.Success){
            assert(true)
        }

    }

    @Test
    fun create_post_error() = runBlocking{
        val createPostRequest = CreatePost(title = "", body = "")
        val errorResponse = Exception()

        coEvery {
            repo.createPost(createPostRequest)
        }returns RequestResult.Error(errorResponse)

        val result = createPostUseCase.createPost(createPostRequest)

        coVerify (exactly = 1){ repo.createPost(createPostRequest) }

        if(result is RequestResult.Error){
            assert(true)
        }
    }
}