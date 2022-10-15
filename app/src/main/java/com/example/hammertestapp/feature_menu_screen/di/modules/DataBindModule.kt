package com.example.hammertestapp.feature_menu_screen.di.modules

import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.data.repository.RepositoryImpl
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.FeedEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.mappers.FoodResponseToFeedEntitiesMapper
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module internal interface DataBindModule {

    @Binds fun bindRepository(
        repository: RepositoryImpl<DomainModel>
    ): Repository<DomainModel>

    @Binds fun bindFoodResponseToFeedEntitiesMapper(
        mapper: FoodResponseToFeedEntitiesMapper
    ): Mapper<@JvmSuppressWildcards FoodResponse, @JvmSuppressWildcards List<FeedEntity>>
}