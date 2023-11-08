package com.comercio.retoandroid.ui.feature.user

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.comercio.core.model.User
import com.comercio.core.model.create_post.CreatePost
import com.comercio.core.model.create_post.CreatePostEventResult
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.core.model.get_posts.GetPostsEventResult
import com.comercio.core.model.user.GetUserEventResult
import com.comercio.retoandroid.databinding.ActivityUsersBinding
import com.comercio.retoandroid.ui.feature.user.adapter.AdapterPost
import com.comercio.retoandroid.ui.feature.user.adapter.AdapterUser
import com.comercio.retoandroid.ui.feature.user.dialog.DialogCreatePost
import com.comercio.retoandroid.ui.util.UtilRecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersActivity : AppCompatActivity() , DialogCreatePost.ActionDialogCreatePost{
    lateinit var binding: ActivityUsersBinding
    lateinit var adapterUser: AdapterUser
    lateinit var adapterPost: AdapterPost
    private var listUser = ArrayList<User>()
    private var listPost = ArrayList<CreatePostResponse>()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        UtilRecyclerView.config(binding.rvUsers, true, this)
        UtilRecyclerView.config(binding.rvPosts, false, this)
        userViewModel.getUsers()
        userViewModel.getPosts()
        observeUsers()
        observeGetPosts()
        observeCreatePost()
        binding.btnCreatePost.setOnClickListener { showDialogCreatePost() }
    }

    private fun observeUsers() {
        userViewModel.usersViewModel.observe(this) {
            when (it) {
                is GetUserEventResult.ShowUsers -> {
                    listUser = it.data
                    setAdapterUser()
                }
                GetUserEventResult.UsersEmpty -> {}
            }
        }
    }
    private fun observeCreatePost() {
        userViewModel.createPostViewModel.observe(this) {
            when (it) {
                is CreatePostEventResult.ErrorGeneral -> {}
                is CreatePostEventResult.Success -> {
                    listPost.add(0, it.data)
                    adapterPost.notifyDataSetChanged()
                }
            }
        }
    }
    private fun observeGetPosts() {
        userViewModel.getPostsViewModel.observe(this) {
            when (it) {
                is GetPostsEventResult.ErrorGeneral -> {}
                is GetPostsEventResult.Success -> {
                    binding.tvNotPost.visibility = View.GONE
                    binding.rvPosts.visibility = View.VISIBLE
                    listPost = it.data
                    setAdapterPosts()
                }
            }
        }
    }

    private fun setAdapterPosts() {
        adapterPost = AdapterPost(listPost)
        binding.rvPosts.adapter = adapterPost
    }

    private fun setAdapterUser() {
        adapterUser = AdapterUser(listUser)
        binding.rvUsers.adapter = adapterUser
    }

    fun showDialogCreatePost() {
        val dialog = DialogCreatePost(this)
        supportFragmentManager.let { dialog.show(it, "") }
    }

    override fun clickCreatepost(title: String, description: String) {
        userViewModel.createPost(CreatePost(title = title, body = description))
    }
}