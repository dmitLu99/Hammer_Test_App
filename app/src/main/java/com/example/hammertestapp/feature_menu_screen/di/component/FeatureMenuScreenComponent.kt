package com.example.hammertestapp.feature_menu_screen.di.component

import com.example.hammertestapp.feature_menu_screen.di.annotations.BaseUrl
import com.example.hammertestapp.feature_menu_screen.di.modules.DataBindModule
import com.example.hammertestapp.feature_menu_screen.di.modules.DataModule
import com.example.hammertestapp.feature_menu_screen.di.modules.DomainBindsModule
import com.example.hammertestapp.feature_menu_screen.di.modules.UIBindsModule
import com.example.hammertestapp.feature_menu_screen.ui.screens.MenuFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class, DataBindModule::class,
        DomainBindsModule::class, UIBindsModule::class
    ]
) internal interface FeatureMenuScreenComponent {

    fun inject(fragment: MenuFragment)

    @Component.Builder interface Builder {

        @BindsInstance fun baseUri(@BaseUrl baseUri: String): Builder

        fun build(): FeatureMenuScreenComponent
    }
}