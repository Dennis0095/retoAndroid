package com.comercio.retoandroid.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comercio.retoandroid.R
import com.comercio.retoandroid.ui.feature.login.LoginState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordToggleTextFieldBacom(
    state: LoginState,
    onPasswordChange: (String) -> Unit,
    label: String,
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.password,
        onValueChange = {
            onPasswordChange(it)
        },
        label = { Text(label, fontSize = 14.sp) },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {

            if (isPasswordVisible) {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = !isPasswordVisible
                        },
                    painter = painterResource(id = R.drawable.eye_open),
                    contentDescription = null
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = !isPasswordVisible
                        },
                    painter = painterResource(id = R.drawable.eye_close),
                    contentDescription = null
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )
    )
}