package com.example.x_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.x_clone.ui.screens.XCloneApp
import com.example.x_clone.ui.theme.X_cloneTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            X_cloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    XCloneApp()
                }
            }
        }
    }
}

