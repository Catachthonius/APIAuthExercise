package com.example.apiauthexercise.network

import com.example.apiauthexercise.model.FoodData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {

    @GET("food")
    suspend fun getFood(
        @Query("limit") limit: Int
    ) : Response<FoodData>
}