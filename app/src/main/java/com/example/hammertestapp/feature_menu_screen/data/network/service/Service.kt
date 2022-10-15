package com.example.hammertestapp.feature_menu_screen.data.network.service

import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

internal interface Service {

    // todo: move headers to constants
    @Headers(
        "X-RapidAPI-Key: ece94b5c88mshc4b8cc295bba6bap1c0fd0jsn7314a1fc59d7",
        "X-RapidAPI-Host: yummly2.p.rapidapi.com"
    )
    @GET("feeds/list") suspend fun fetchFoodResponse(
        @Query("start") start: Int = 0,
        @Query("limit") limit: Int = 24,
    ): Response<FoodResponse>
}