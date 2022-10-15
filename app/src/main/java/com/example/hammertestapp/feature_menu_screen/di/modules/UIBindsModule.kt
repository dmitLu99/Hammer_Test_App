package com.example.hammertestapp.feature_menu_screen.di.modules

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainBanner
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainCategory
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.ui.models.BannersContainer
import com.example.hammertestapp.feature_menu_screen.ui.models.CategoriesContainer
import com.example.hammertestapp.feature_menu_screen.ui.models.MenuItemsContainer
import com.example.hammertestapp.feature_menu_screen.ui.models.mappers.DomainBannerToBannersContainerMapper
import com.example.hammertestapp.feature_menu_screen.ui.models.mappers.DomainCategoriesToCategoriesContainerMapper
import com.example.hammertestapp.feature_menu_screen.ui.models.mappers.DomainModelToMenuItemContainerMapper
import dagger.Binds
import dagger.Module

@Module internal interface UIBindsModule {

    @Binds fun bindDomainBannerMapper(
        mapper: DomainBannerToBannersContainerMapper
    ) : Mapper<List<DomainBanner>, BannersContainer>

    @Binds fun bindDomainCategoriesMapper(
        mapper: DomainCategoriesToCategoriesContainerMapper
    ) : Mapper<List<DomainCategory>, CategoriesContainer>

    @Binds fun bindDomainModelMapper(
        mapper: DomainModelToMenuItemContainerMapper
    ) : Mapper<DomainModel, MenuItemsContainer>
}