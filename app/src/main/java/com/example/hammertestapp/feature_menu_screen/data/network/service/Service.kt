package com.example.hammertestapp.feature_menu_screen.data.network.service

import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.data.network.utils.Config.FIRST_HEADER
import com.example.hammertestapp.feature_menu_screen.data.network.utils.Config.SECOND_HEADER
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

internal interface Service {

    @[Headers(FIRST_HEADER, SECOND_HEADER) GET("feeds/list")] suspend fun fetchFoodResponse(
        @Query("start") start: Int = 0,
        @Query("limit") limit: Int = 24,
    ): Response<FoodResponse>
}