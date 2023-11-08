package com.comercio.retoandroid.ui.feature.user.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comercio.retoandroid.R

@Composable
fun ListPostScrren(
    state: UsersState,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(4.dp)
    ) {
        items(state.listPosts.size) { index ->
            val post = state.listPosts[index]
            ListItem(titulo = post.title, description = post.body)
        }
    }
}

@Composable
fun ListItem(titulo: String, description: String) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.small,
        color = colorResource(id = R.color.greyTrans)
    ) {
        Column() {
            Text(
                text = titulo,
                modifier = Modifier
                    .padding(16.dp)
                    .width(120.dp),
                maxLines = 2,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.black)
            )
            Text(
                text = description,
                modifier = Modifier
                    .padding(16.dp)
                    .width(140.dp),
                maxLines = 4,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.grey_arrow)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    ListPostScrren(UsersState())
}
