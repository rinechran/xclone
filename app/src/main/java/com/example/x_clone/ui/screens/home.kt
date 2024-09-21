package com.example.x_clone.ui.screens

import android.accounts.Account
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.x_clone.repository.ObjectBox
import com.example.x_clone.repository.entity.AccountEntity

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun XCloneApp( ) {

    val context = LocalContext.current;
   ObjectBox.init(context);

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Greeting("A", modifier = Modifier)
        }
    }
}
