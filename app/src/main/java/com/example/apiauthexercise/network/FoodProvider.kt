package com.example.apiauthexercise.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoodProvider {

    private val baseUrl = "https://indnutrientsapi.tech/"
    private val loggingInterceptor = HttpLoggingInterceptor()
    private val authInterceptor = AuthInterceptor()

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(FoodService::class.java)

    fun provide(): FoodService {
        return service
    }
}