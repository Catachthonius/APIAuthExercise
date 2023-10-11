package com.example.apiauthexercise

import android.app.Application
import com.example.apiauthexercise.network.FoodProvider

class MyApplication : Application() {

    private val provider = FoodProvider().provide()
    val viewModelFactory = MainViewModelFactory(provider)

    override fun onCreate() {
        super.onCreate()
    }

}