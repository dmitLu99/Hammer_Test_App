package com.example.hammertestapp.feature_menu_screen.domain.models.mappers

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainBanner
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainCategory
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainMenuItem
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class FoodResponseToMenuDomainModelMapper @Inject constructor(

) : Mapper<FoodResponse, DomainModel> {

    override suspend fun map(from: FoodResponse): DomainModel =
        withContext(context = Dispatchers.Default) {
            with(from.feed!!) {
                return@with DomainModel(
                    banners = listOf(
                        DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
                        DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
                        DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
                        DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg")
                    ),
                    categories = listOf(
                        DomainCategory(name = "Pizza"),
                        DomainCategory(name = "Combo"),
                        DomainCategory(name = "Dessert"),
                        DomainCategory(name = "Drinks"),
                        DomainCategory(name = "Discounts")
                    ),
                    menuItems = List(size = size) { index ->
                        DomainMenuItem(
                            imageUri = get(index).display!!.images!![0],
                            title = get(index).display!!.flag!!,
                            description = get(index).display!!.displayName!!,
                            price = get(index).content!!.yums!!.price!!
                        )
                    }
                )
            }
        }
}