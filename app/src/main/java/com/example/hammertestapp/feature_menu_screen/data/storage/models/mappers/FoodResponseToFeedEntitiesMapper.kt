package com.example.hammertestapp.feature_menu_screen.data.storage.models.mappers

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.ContentEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.DisplayItemEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.FeedEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.YumsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class FoodResponseToFeedEntitiesMapper @Inject constructor(
) : Mapper<@JvmSuppressWildcards FoodResponse, @JvmSuppressWildcards List<FeedEntity>> {

    override suspend fun map(
        from: FoodResponse
    ): List<FeedEntity> = withContext(Dispatchers.Default) {
        with(from.feed!!) {
            return@withContext List(size = size) { index ->
                FeedEntity(
                    id = index,
                    display = DisplayItemEntity(
                        id = index,
                        displayName = get(index = index).display!!.displayName!!,
                        images = get(index = index).display!!.images!!,
                        flag = get(index = index).display!!.flag!!
                    ),
                    content = ContentEntity(
                        id = index,
                        yums = YumsEntity(
                            id = index,
                            price = get(index = index).content!!.yums!!.price!!
                        )
                    )
                )
            }
        }
    }
}