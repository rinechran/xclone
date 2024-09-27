package com.example.x_clone.network

import com.example.x_clone.network.dto.LoginRequest
import com.example.x_clone.network.dto.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface SiteApi {
    @POST("auth")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}
object SiteDataSource {
    val api : SiteApi
    init{
        val retrofitBuilder = Retrofit.Builder()
         api = retrofitBuilder
            .baseUrl("http://192.168.68.116:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SiteApi::class.java)
    }

    suspend fun login(email: String, password: String): LoginResponse? {
        return try {
            val response = api.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}