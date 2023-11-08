package com.comercio.retoandroid.ui.feature.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comercio.retoandroid.R
import com.comercio.retoandroid.commons.ButtonBacom
import com.comercio.retoandroid.commons.CheckBoxBacom
import com.comercio.retoandroid.commons.PasswordToggleTextFieldBacom
import com.comercio.retoandroid.ui.feature.user.UsersActivity
import com.comercio.retoandroid.ui.theme.RetoAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    //private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //viewModel = hiltViewModel()
            RetoAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(initActivity = {
                        initActivity()
                    })
                }
            }
        }
    }

    fun initActivity(){
        startActivity(Intent(this, UsersActivity::class.java))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier, name: String, onNameChange: (String) -> Unit, initActivity: Runnable) {

    var password by remember { mutableStateOf("") }

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
        ){
            Column()
            {
                Text(text = stringResource(id = R.string.welcome))
                Text(text = stringResource(id = R.string.logIn),
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    label = { Text(text = stringResource(id = R.string.email), fontSize = 14.sp)},
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(12.dp))
                PasswordToggleTextFieldBacom(
                    password = password,
                    onPasswordChange = { newPassword -> password = newPassword },
                    label = stringResource(id = R.string.password)
                )

                Text(text = stringResource(id = R.string.forgotPassword),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.purple_700)
                )

                Spacer(modifier = Modifier.height(12.dp))

                CheckBoxBacom(isChecked = true, clickCheck = {})

                Spacer(modifier = Modifier.height(32.dp))

                ButtonBacom(text = stringResource(id = R.string.into), onClick = {
                    initActivity.run()
                })
                //
            }
        }
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

@Composable
fun LoginScreen(initActivity: Runnable) {
    var name by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val backgroundImage = painterResource(id = R.drawable.background_login)
    val imageBitmap = ImageBitmap.imageResource(context.resources, R.drawable.background_login)

    BackgroundImageSurface(imageBitmap  = imageBitmap ) {
        Greeting(name = name, onNameChange = { itNameChange -> name = itNameChange }, initActivity = initActivity)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    LoginScreen(initActivity = {

    })
}