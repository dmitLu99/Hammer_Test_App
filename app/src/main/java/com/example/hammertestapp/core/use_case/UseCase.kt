package com.example.hammertestapp.core.use_case

import com.example.hammertestapp.core.utils.markers.DisplayableItem

/**
 * @param DI displayable item that will be returned
 * */
interface UseCase<out DI : DisplayableItem> {

    suspend fun execute(): DI
}