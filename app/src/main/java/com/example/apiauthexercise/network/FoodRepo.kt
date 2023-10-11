package com.example.apiauthexercise.network

import com.example.apiauthexercise.model.FoodData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object FoodRepo {

    var foodService: FoodService? = null

    suspend fun getFood(): Response<FoodData>? {
        if (foodService == null) {
            foodService = createRetrofitInstance().create(FoodService::class.java)
        }
        return foodService?.getFood(limit = 10)
    }

    private fun createRetrofitInstance(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val authInterceptor = AuthInterceptor()
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://indnutrientsapi.tech/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}