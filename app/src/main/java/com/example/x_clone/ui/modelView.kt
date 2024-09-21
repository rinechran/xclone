package com.example.x_clone.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


sealed interface AppMainUiState {
    data object NotReady : AppMainUiState
    data object Login : AppMainUiState
    data object NotLogin : AppMainUiState
}

class MainModelView : ViewModel(){
    var stateUiState : AppMainUiState by mutableStateOf(AppMainUiState.NotReady)
        private set

}