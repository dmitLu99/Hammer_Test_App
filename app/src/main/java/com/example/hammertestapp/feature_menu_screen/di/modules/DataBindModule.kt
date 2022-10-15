package com.example.hammertestapp.feature_menu_screen.di.modules

import com.example.hammertestapp.feature_menu_screen.data.repository.RepositoryImpl
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module internal interface DataBindModule {

    @Binds fun bindRepository(
        repository: RepositoryImpl<DomainModel>
    ): Repository<DomainModel>
}