package com.example.apiauthexercise.model
import com.google.gson.annotations.SerializedName


data class FoodData(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("food")
    val food: List<Food>?
)

data class Food(
    @SerializedName("calories")
    val calories: Int?,
    @SerializedName("core")
    val core: String?,
    @SerializedName("core_uri")
    val coreUri: String?,
    @SerializedName("food_name")
    val foodName: String?,
    @SerializedName("food_nutrition")
    val foodNutrition: List<FoodNutrition?>?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("quantity")
    val quantity: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("type_uri")
    val typeUri: String?,
    @SerializedName("uri")
    val uri: String?
)

data class FoodNutrition(
    @SerializedName("nutrient_name")
    val nutrientName: String?,
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("value")
    val value: Double?
)