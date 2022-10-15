package com.example.hammertestapp.feature_menu_screen.domain.repository

/**
 * @param DM domain model that will be returned
 * */
internal interface Repository<DM> {

    suspend fun fetchData(): DM
}