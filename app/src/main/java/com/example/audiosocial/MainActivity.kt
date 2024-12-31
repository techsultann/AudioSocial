package com.example.audiosocial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.audiosocial.navigation.RootNavHost
import com.example.audiosocial.ui.theme.AudioSocialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AudioSocialTheme {
                RootNavHost(rememberNavController())
            }
        }
    }
}