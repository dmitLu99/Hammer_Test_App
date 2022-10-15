package com.example.hammertestapp.feature_menu_screen.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hammertestapp.core.use_case.UseCase
import com.example.hammertestapp.feature_menu_screen.ui.models.*
import com.example.hammertestapp.feature_menu_screen.ui.models.BannersContainer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MenuScreenViewModel(
    private val fetchDomainModelUseCase: UseCase<MenuItemsContainer>,
    private val fetchBannersUseCase: UseCase<BannersContainer>,
    private val fetchCategoriesUseCase: UseCase<CategoriesContainer>
) : ViewModel() {

    val testMenuItemsContainer: MenuItemsContainer = MenuItemsContainer(listOf(
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
        MenuItem(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg",
        title = "Title title", description = "description description description", price = 350),
    ))

    val testBannersContainer: BannersContainer = BannersContainer(listOf(
        Banner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
        Banner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
        Banner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg"),
        Banner(imageUrl = "https://s3.eu-north-1.amazonaws.com/restoraids/media/redfood.jpg")
    ))

    val testCategoriesContainer: CategoriesContainer = CategoriesContainer(listOf(
        Category(name = "caregory"),
        Category(name = "caregory"),
        Category(name = "caregory"),
        Category(name = "caregory")
    ))

    private val _bannersLiveData = MutableLiveData<BannersContainer>()
    val bannersLiveData: LiveData<BannersContainer> get() = _bannersLiveData

    private val _categoriesLiveData = MutableLiveData<CategoriesContainer>()
    val categoriesLiveData: LiveData<CategoriesContainer> get() = _categoriesLiveData

    private val _menuItemsLiveData = MutableLiveData<MenuItemsContainer>()
    val menuItemsLiveData: LiveData<MenuItemsContainer> get() = _menuItemsLiveData

    fun fetchDisplayableItems() {
        CoroutineScope(context = Dispatchers.Default).launch {
            // todo: handle errors
//            _bannersLiveData.postValue(fetchBannersUseCase.execute())
//            _categoriesLiveData.postValue(fetchCategoriesUseCase.execute())
//            _menuItemsLiveData.postValue(fetchDomainModelUseCase.execute())
            _bannersLiveData.postValue(testBannersContainer)
            _categoriesLiveData.postValue(testCategoriesContainer)
            _menuItemsLiveData.postValue(testMenuItemsContainer)
        }
    }


    @Suppress("UNCHECKED_CAST") class Factory @Inject constructor(
        private val fetchDomainModelUseCase: UseCase<MenuItemsContainer>,
        private val fetchBannersUseCase: UseCase<BannersContainer>,
        private val fetchCategoriesUseCase: UseCase<CategoriesContainer>
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MenuScreenViewModel(
                fetchDomainModelUseCase = fetchDomainModelUseCase,
                fetchBannersUseCase = fetchBannersUseCase,
                fetchCategoriesUseCase = fetchCategoriesUseCase
            ) as T
        }
    }
}

