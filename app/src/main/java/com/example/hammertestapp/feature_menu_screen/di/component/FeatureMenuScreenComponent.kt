package com.example.hammertestapp.feature_menu_screen.di.component

import android.app.Application
import com.example.hammertestapp.feature_menu_screen.di.annotations.BaseUrl
import com.example.hammertestapp.feature_menu_screen.di.modules.*
import com.example.hammertestapp.feature_menu_screen.di.modules.DataBindModule
import com.example.hammertestapp.feature_menu_screen.di.modules.DataModule
import com.example.hammertestapp.feature_menu_screen.di.modules.DomainBindsModule
import com.example.hammertestapp.feature_menu_screen.di.modules.UIBindsModule
import com.example.hammertestapp.feature_menu_screen.di.modules.UIModule
import com.example.hammertestapp.feature_menu_screen.ui.screens.MenuFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@[Component(
    modules = [
        DataModule::class, DataBindModule::class,
        DomainBindsModule::class, UIBindsModule::class, UIModule::class
    ]
) Singleton] internal interface FeatureMenuScreenComponent {

    fun inject(fragment: MenuFragment)

    @Component.Builder interface Builder {

        @BindsInstance fun baseUri(@BaseUrl baseUri: String): Builder

        @BindsInstance fun application(application: Application): Builder

        fun build(): FeatureMenuScreenComponent
    }
}