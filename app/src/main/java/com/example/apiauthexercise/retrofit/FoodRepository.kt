package com.example.apiauthexercise.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object FoodRepository {

    var foodEndPoint: FoodEndPoint? = null

    suspend fun getFood(): Response<FoodData>? {
        if (foodEndPoint == null) {
            foodEndPoint = createRetrofitInstance().create(FoodEndPoint::class.java)
        }
        return foodEndPoint?.getFood(limit = 10)
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