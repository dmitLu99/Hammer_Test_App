package com.example.hammertestapp.feature_menu_screen.domain.models

internal data class DomainModel(
    val banners: List<DomainBanner> = listOf(),
    val categories: List<DomainCategory> = listOf(),
    val menuItems: List<DomainMenuItem>
)