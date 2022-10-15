package com.example.hammertestapp.feature_menu_screen.domain.models.mappers

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.FeedEntity
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainBanner
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainCategory
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainMenuItem
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class FeedEntitiesToDomainModelMapper @Inject constructor(
) : Mapper<@JvmSuppressWildcards List<FeedEntity>, @JvmSuppressWildcards DomainModel> {

    override suspend fun map(
        from: List<FeedEntity>
    ): DomainModel = withContext(Dispatchers.Default) {
        return@withContext DomainModel(
            banners = listOf(
                DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
                DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
                DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
                DomainBanner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg")
            ),
            categories = listOf(
                DomainCategory(name = "Pizza"),
                DomainCategory(name = "Combo"),
                DomainCategory(name = "Desserts"),
                DomainCategory(name = "Drinks"),
                DomainCategory(name = "Stocks"),
            ),
            menuItems = List(size = from.size) { index ->
                DomainMenuItem(
                    imageUri = from[index].display.images[0],
                    title = from[index].display.flag,
                    description = from[index].display.displayName,
                    price = from[index].content.yums.price
                )
            },
        )
    }
}