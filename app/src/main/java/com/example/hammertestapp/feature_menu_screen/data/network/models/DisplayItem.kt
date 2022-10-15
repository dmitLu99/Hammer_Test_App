package com.example.hammertestapp.feature_menu_screen.data.network.models

import com.google.gson.annotations.SerializedName

internal data class DisplayItem( // todo: rename?
    @SerializedName("displayName") val displayName: String? = "Recommended By Yummly",
    @SerializedName("images") val images: List<String>? = listOf("https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
    @SerializedName("flag") val flag: String? = "Try It Now"
)