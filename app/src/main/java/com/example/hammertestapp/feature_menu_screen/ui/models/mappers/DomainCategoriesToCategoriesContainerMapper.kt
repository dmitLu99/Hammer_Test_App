package com.example.hammertestapp.feature_menu_screen.ui.models.mappers

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainCategory
import com.example.hammertestapp.feature_menu_screen.ui.models.CategoriesContainer
import com.example.hammertestapp.feature_menu_screen.ui.models.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class DomainCategoriesToCategoriesContainerMapper @Inject constructor(

) : Mapper<@JvmSuppressWildcards List<DomainCategory>, CategoriesContainer> {

    override suspend fun map(from: List<DomainCategory>): CategoriesContainer =
        withContext(Dispatchers.Default) {
            return@withContext CategoriesContainer(
                categories = List(size = from.size) { index ->
                    Category(name = from[index].name, isClicked = index == 0)
                }
            )
        }
}