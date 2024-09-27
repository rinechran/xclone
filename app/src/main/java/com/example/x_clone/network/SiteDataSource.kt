package com.example.x_clone.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface SiteApi {
}

object SiteDataSource {
    val api : SiteApi
    init{
        val retrofitBuilder = Retrofit.Builder()
         api = retrofitBuilder
            .baseUrl("http://127.0.0.1:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SiteApi::class.java)
    }

}