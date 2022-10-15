package com.example.hammertestapp.feature_menu_screen.data.network.models

import com.google.gson.annotations.SerializedName

internal data class DisplayItem( // todo: rename?
    @SerializedName("displayName") val displayName: String? = "Recommended By Yummly",
    @SerializedName("images") val images: List<String>? = listOf("https://lh3.googleusercontent.com/DdIxWsMN4NsGNIbkiHIeuF5oyMd9ID2y1Oa6DWceINv10w4d7_D6TBgLeH7AABE2M0ZrY5pAc2xHNuWmzm9cPg"),
    @SerializedName("flag") val flag: String? = "Try It Now"
)