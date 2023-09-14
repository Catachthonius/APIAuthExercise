package com.example.apiauthexercise.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {
        val result = MutableLiveData<FoodData?>()

        fun getFood(){

            viewModelScope.launch(Dispatchers.IO){
                var response = FoodRepository.getFood()
                if (response?.isSuccessful == true) {
                    val foodList = response.body()?.food
                    val countList = response.body()?.count
                    val foodData = FoodData(food = foodList, count = countList)
                    result.postValue(foodData)
                    Log.i("Dishes of today:", "$foodData")
                } else {
                    Log.e("NETWORK ERROR","Network Call failed")
                }
            }

        }
    }