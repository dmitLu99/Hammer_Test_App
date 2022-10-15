package com.example.hammertestapp.feature_menu_screen.di.modules

import android.app.Application
import androidx.room.Room
import com.example.hammertestapp.feature_menu_screen.data.network.service.Service
import com.example.hammertestapp.feature_menu_screen.data.storage.database.MenuDatabase
import com.example.hammertestapp.feature_menu_screen.di.annotations.BaseUrl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module internal class DataModule {

    @Provides fun providesGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides fun provideRetrofitService(
        @BaseUrl baseUrl: String, factory: GsonConverterFactory
    ): Service =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .build()
            .create(Service::class.java)

    @[Provides Singleton] fun provideMenuDatabase(application: Application): MenuDatabase =
        Room.databaseBuilder(
            application.applicationContext, MenuDatabase::class.java, "MenuDB"
        ).build()

}