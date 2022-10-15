package com.example.hammertestapp.feature_menu_screen.ui.models.mappers

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.ui.models.*
import com.example.hammertestapp.feature_menu_screen.ui.models.MenuItemsContainer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class DomainModelToMenuItemContainerMapper @Inject constructor(

) : Mapper<DomainModel, MenuItemsContainer> {

    override suspend fun map(from: DomainModel): MenuItemsContainer =
        withContext(context = Dispatchers.Default) {
            with(from) {
                return@withContext MenuItemsContainer(menuItems = List(menuItems.size) { index ->
                    MenuItem(
                        imageUrl = menuItems[index].imageUri,
                        title = menuItems[index].title,
                        description = menuItems[index].description,
                        price = menuItems[index].price
                    )
                })
            }
        }
}