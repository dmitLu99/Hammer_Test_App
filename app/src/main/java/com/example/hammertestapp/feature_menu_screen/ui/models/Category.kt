package com.example.hammertestapp.feature_menu_screen.ui.models

import com.example.hammertestapp.core.utils.markers.DisplayableItem

internal data class Category(
    val name: String,
    var isClicked: Boolean = false
) : DisplayableItem