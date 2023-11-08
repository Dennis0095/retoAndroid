package com.comercio.retoandroid.ui.feature.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.comercio.retoandroid.ui.feature.user.UsersActivity
import com.comercio.retoandroid.ui.theme.RetoAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(initActivity = {
                        initUserActivity()
                    })
                }
            }
        }
    }

    fun initUserActivity() {
        startActivity(Intent(this, UsersActivity::class.java))// diseño en xml 100% funcional
        //startActivity(Intent(this, UsersMainActivity::class.java))// descomentar para ver el diseño en compose 80% funcional
    }
}