package com.example.hammertestapp.feature_menu_screen.di.modules

import com.example.hammertestapp.core.use_case.UseCase
import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.domain.models.mappers.FoodResponseToMenuDomainModelMapper
import com.example.hammertestapp.feature_menu_screen.domain.use_cases.FetchBannersUseCase
import com.example.hammertestapp.feature_menu_screen.domain.use_cases.FetchCategoriesUseCase
import com.example.hammertestapp.feature_menu_screen.domain.use_cases.FetchDomainModelUseCase
import com.example.hammertestapp.feature_menu_screen.ui.models.BannersContainer
import com.example.hammertestapp.feature_menu_screen.ui.models.CategoriesContainer
import com.example.hammertestapp.feature_menu_screen.ui.models.MenuItemsContainer
import dagger.Binds
import dagger.Module

@Module internal interface DomainBindsModule {

    @Binds fun bindResponseMapper(
        mapper: FoodResponseToMenuDomainModelMapper
    ): Mapper<FoodResponse, DomainModel>

    @Binds fun bindFetchBannersUseCase(
        useCase: FetchBannersUseCase<BannersContainer>
    ): UseCase<BannersContainer>

    @Binds fun bindFetchCategoriesUseCase(
        useCase: FetchCategoriesUseCase<CategoriesContainer>
    ): UseCase<CategoriesContainer>

    @Binds fun bindFetchDomainModelUseCase(
        useCase: FetchDomainModelUseCase<MenuItemsContainer>
    ): UseCase<MenuItemsContainer>
}