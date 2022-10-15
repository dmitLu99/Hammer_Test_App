package com.example.hammertestapp.feature_menu_screen.view_models

import androidx.lifecycle.ViewModel
import com.example.hammertestapp.feature_menu_screen.di.component.DaggerFeatureMenuScreenComponent
import com.example.hammertestapp.feature_menu_screen.di.component.FeatureMenuScreenComponent

internal const val BASE_URL = "https://yummly2.p.rapidapi.com/"

internal class ComponentViewModel : ViewModel() {

    private val daggerComponent: FeatureMenuScreenComponent = DaggerFeatureMenuScreenComponent
        .builder()
        .baseUri(baseUri = BASE_URL)
        .build()

    fun fetchComponent() = daggerComponent
}