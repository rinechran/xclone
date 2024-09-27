package com.example.x_clone.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.x_clone.network.SiteDataSource
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

class XCloneViewModel : ViewModel() {
    var _isLoggedIn = mutableStateOf(false)
        private set
    val isLoggedIn: State<Boolean> = _isLoggedIn

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun login(){
        viewModelScope.launch {
            val loginResponse = SiteDataSource.login(email, password)
            if (loginResponse != null && loginResponse.message!="") {
                _isLoggedIn.value = true
            } else {
                _isLoggedIn.value = false
            }
        }
    }
}