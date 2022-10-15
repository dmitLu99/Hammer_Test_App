package com.example.hammertestapp.feature_menu_screen.data.network.models

import com.google.gson.annotations.SerializedName

internal data class Feed(
    @SerializedName("display") val display: DisplayItem? = DisplayItem(),
    @SerializedName("content") val content: Content? = Content(),
)