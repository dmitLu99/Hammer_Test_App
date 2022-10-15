package com.example.hammertestapp.feature_menu_screen.di.modules

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.hammertestapp.R
import com.example.hammertestapp.feature_menu_screen.di.annotations.Banner
import com.example.hammertestapp.feature_menu_screen.di.annotations.Menu
import dagger.Module
import dagger.Provides

@Module internal class UIModule {

    @[Provides Menu] fun providesMenuRequestOptions(): RequestOptions = RequestOptions()
        .error(R.drawable.ic_error_outline_24)
        .placeholder(R.drawable.ic_outline_download_24)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    @[Provides Banner] fun providesBannerRequestOptions(): RequestOptions = RequestOptions()
        .error(R.drawable.ic_error_outline_24)
        .placeholder(R.drawable.ic_outline_download_24)
}