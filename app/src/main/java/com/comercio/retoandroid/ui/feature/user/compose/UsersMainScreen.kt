package com.comercio.retoandroid.ui.feature.user.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.comercio.core.model.create_post.CreatePost
import com.comercio.retoandroid.R

@Composable
fun UsersMainScreen(
    viewModel: UsersMainViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = null) {
        viewModel.getPosts()
        viewModel.getUsers()
        viewModel.events.collect {
            when (it) {
                UsersMainViewModel.UIEvents.ErrorService -> {
                }
            }
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val (listPost, listUsers, button) = createRefs()

        ListPostScrren(state = viewModel.state.value, modifier = Modifier
            .constrainAs(listPost) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        ListUsersScreen(state = viewModel.state.value, modifier = Modifier
            .constrainAs(listUsers) {
                top.linkTo(listPost.bottom, 44.dp)
                start.linkTo(parent.start, 24.dp)
                end.linkTo(parent.end, 24.dp)
                bottom.linkTo(parent.bottom, 44.dp)
            })

        Button(
            onClick = {
                viewModel.createPost(
                    CreatePost(
                        title = "Nuevo post",
                        body = "contenido de la publicacipón"
                    )
                )
            },
            modifier = Modifier
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Text(text = stringResource(id = R.string.createApost))
        }
    }
}