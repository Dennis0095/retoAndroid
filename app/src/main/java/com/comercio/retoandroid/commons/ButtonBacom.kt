package com.comercio.retoandroid.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comercio.retoandroid.R

@Composable
fun ButtonBacom(
    onClick: Runnable,
    text: String
) {
    Button(
        onClick = { onClick.run() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.white),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(color = Color.Transparent)
        )
    }
}