package com.example.apiauthexercise.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .addHeader("X-RapidAPI-Key", "ca6fe72453msh58e9682953037adp1df8a9jsn828316eb0e81")
                .addHeader("X-RapidAPI-Host", "ind-nutrient-api1.p.rapidapi.com")
                .build()

            return chain.proceed(newRequest)
        }
    }