package com.comercio.retoandroid.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.comercio.retoandroid.R

val modifierRedSocial = Modifier
    .fillMaxWidth()
    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
    .border(
        1.dp,
        Color.Transparent,
        shape = RoundedCornerShape(24.dp)
    )
    .background(
        color = Color.Black,
        shape = RoundedCornerShape(24.dp)
    )
    .padding(8.dp)

@Composable
fun RowButtonBacom() {
    Row() {
        Row(
            modifier = modifierRedSocial,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.gmail),
                contentDescription = stringResource(id = R.string.loginContinueGmail), modifier = Modifier
                    .width(25.dp)
                    .height(25.dp).padding(start = 12.dp)
            )
            Text(
                text = stringResource(id = R.string.loginContinueGmail),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}