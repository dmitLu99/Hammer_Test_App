package com.example.hammertestapp.feature_menu_screen.ui.models.mappers

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainBanner
import com.example.hammertestapp.feature_menu_screen.ui.models.Banner
import com.example.hammertestapp.feature_menu_screen.ui.models.BannersContainer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class DomainBannerToBannersContainerMapper @Inject constructor(

) : Mapper<@JvmSuppressWildcards List<DomainBanner>, BannersContainer> {

    override suspend fun map(from: List<DomainBanner>): BannersContainer =
        withContext(context = Dispatchers.Default) {
            return@withContext BannersContainer(
                banners = List(size = from.size) { index -> Banner(imageUrl = from[index].imageUrl) }
            )
        }
}