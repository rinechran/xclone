package com.example.x_clone.data

import retrofit2.Call
import com.example.x_clone.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface PhotoApi {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}

object PhotoDataSource {
    val api : PhotoApi
    init{
        val retrofitBuilder = Retrofit.Builder()
         api = retrofitBuilder
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApi::class.java)
    }



}