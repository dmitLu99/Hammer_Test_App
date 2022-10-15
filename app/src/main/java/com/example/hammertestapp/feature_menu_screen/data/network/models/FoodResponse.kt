package com.example.hammertestapp.feature_menu_screen.data.network.models

import com.google.gson.annotations.SerializedName

internal data class FoodResponse(
    @SerializedName("feed") val feed: List<Feed>? = listOf(),
)