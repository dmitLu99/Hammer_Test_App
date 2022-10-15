package com.example.hammertestapp.feature_menu_screen.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.hammertestapp.feature_menu_screen.di.component.DaggerFeatureMenuScreenComponent
import com.example.hammertestapp.feature_menu_screen.di.component.FeatureMenuScreenComponent

internal const val BASE_URL = "https://yummly2.p.rapidapi.com/"

internal class ComponentViewModel(application: Application) : AndroidViewModel(application) {

    private val daggerComponent: FeatureMenuScreenComponent = DaggerFeatureMenuScreenComponent
        .builder()
        .baseUri(baseUri = BASE_URL)
        .application(application = this.getApplication())
        .build()

    fun fetchComponent() = daggerComponent
}