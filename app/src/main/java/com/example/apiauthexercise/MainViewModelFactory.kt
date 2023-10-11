package com.example.apiauthexercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apiauthexercise.network.FoodService
import com.example.apiauthexercise.ui.FoodViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val service : FoodService) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)){
            return FoodViewModel(service) as T
        } else {
            throw IllegalArgumentException("Unknown view model")
        }
    }
}