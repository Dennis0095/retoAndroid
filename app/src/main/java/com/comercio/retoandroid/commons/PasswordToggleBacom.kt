package com.comercio.retoandroid.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comercio.retoandroid.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordToggleTextFieldBacom(
    password: String,
    onPasswordChange: (String) -> Unit,
    label: String,
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = {
            onPasswordChange(it)
        },
        label = { Text(label, fontSize = 14.sp) },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        //viewModel.changePasswordVisibility()
                        isPasswordVisible = !isPasswordVisible
                    },
                painter = painterResource(id = R.drawable.eye_open),
                contentDescription = null
            )
            if (isPasswordVisible) {
                Image(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.eye_open),
                    contentDescription = null
                )
            }
        }
    )
}