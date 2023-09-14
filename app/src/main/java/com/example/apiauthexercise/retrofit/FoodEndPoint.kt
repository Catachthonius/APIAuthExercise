package com.example.apiauthexercise.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodEndPoint {

    @GET("food")
    suspend fun getFood(
        @Query("limit") limit: Int
    ) : Response<FoodData>
}