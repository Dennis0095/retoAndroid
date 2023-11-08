package com.comercio.retoandroid.ui.feature.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.comercio.retoandroid.R
import com.comercio.retoandroid.commons.ButtonBacom
import com.comercio.retoandroid.commons.CheckBoxBacom
import com.comercio.retoandroid.commons.PasswordToggleTextFieldBacom
import com.comercio.retoandroid.commons.RowButtonBacom


@Composable
fun LoginScreen(
    initActivity: Runnable,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val imageBitmap = ImageBitmap.imageResource(context.resources, R.drawable.background_login)

    LaunchedEffect(key1 = null) {
        viewModel.events.collect {
            when (it) {
                LoginViewModel.UIEvents.ErrorService -> {}
                LoginViewModel.UIEvents.GoUsers -> {
                    initActivity.run()
                }
            }
        }
    }

    BackgroundImageSurface(imageBitmap = imageBitmap) {
        ContentLogin(
            state = viewModel.state.value,
            onEmailChange = { newEmail -> viewModel.updateEmail(newEmail) },
            onPasswordChange = { newPassword -> viewModel.updatePassword(newPassword) },
            initActivity = {
                viewModel.login()
            }
        )
    }
}

@Composable
fun BackgroundImageSurface(
    imageBitmap: ImageBitmap,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.2f))
            .drawBehind { drawImage(imageBitmap) },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentLogin(
    modifier: Modifier = Modifier,
    state: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    initActivity: Runnable
) {

    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(start = 32.dp, end = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.9f))
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column()
            {
                Text(text = stringResource(id = R.string.welcome))
                Text(
                    text = stringResource(id = R.string.logIn),
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    value = state.email,
                    onValueChange = onEmailChange,
                    label = { Text(text = stringResource(id = R.string.email), fontSize = 14.sp) },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(12.dp))
                PasswordToggleTextFieldBacom(
                    state = state,
                    onPasswordChange = onPasswordChange,
                    label = stringResource(id = R.string.password)
                )

                Text(
                    text = stringResource(id = R.string.forgotPassword),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.purple_700)
                )

                Spacer(modifier = Modifier.height(12.dp))

                CheckBoxBacom(isChecked = true, clickCheck = {})

                Spacer(modifier = Modifier.height(32.dp))

                ButtonBacom(text = stringResource(id = R.string.into), onClick = {
                    if(state.email.isNotBlank() && state.password.isNotBlank()){
                        initActivity.run()
                    }
                })
                RowButtonBacom()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    LoginScreen(initActivity = {})
}