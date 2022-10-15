package com.example.hammertestapp.feature_menu_screen.ui.models

import com.example.hammertestapp.core.utils.markers.DisplayableItem
import com.example.hammertestapp.feature_menu_screen.ui.models.Banner

internal data class BannersContainer(
    val banners: List<Banner> = listOf()
) : DisplayableItem