package com.example.hammertestapp.feature_menu_screen.data.network.models

import com.google.gson.annotations.SerializedName

internal data class Content(
    @SerializedName("yums") val yums: Yums? = Yums(price = 350)
)