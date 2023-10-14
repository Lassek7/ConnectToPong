package com.example.connecttopong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.connecttopong.ui.theme.ConnectToPongTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectToPongTheme {
                LoginAuth()
            }
        }
    }
}

@Composable
private fun LoginAuth(modifier: Modifier = Modifier){
    var loginSuccess by rememberSaveable { mutableStateOf(false)}

    Surface(modifier) {
        if (loginSuccess){
            //MainApp()
        } else {
            Login(onClickLogin = {})
        }
    }
}

