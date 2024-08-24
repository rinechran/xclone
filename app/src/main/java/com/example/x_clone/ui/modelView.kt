package com.example.x_clone.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.x_clone.data.PhotoDataSource
import com.example.x_clone.model.Photo
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException



sealed interface StartUiState {
    data class Success(val message : String) : StartUiState
    object Error : StartUiState
    object Loading : StartUiState
}

class xCloneModelView : ViewModel(){
    var stateUiState: StartUiState by mutableStateOf(StartUiState.Loading)
        private set

     lateinit var photos : List<Photo>
     init{
         getPhotos()
     }

    fun getPhotos() {
        stateUiState = StartUiState.Loading

        viewModelScope.launch {
            stateUiState = try {
                photos = PhotoDataSource.api.getPhotos()
                StartUiState.Success(
                    "Success"
                )
            } catch (e: IOException) {
                StartUiState.Error
            } catch (e: HttpException) {
                StartUiState.Error
            }
        }

    }


}