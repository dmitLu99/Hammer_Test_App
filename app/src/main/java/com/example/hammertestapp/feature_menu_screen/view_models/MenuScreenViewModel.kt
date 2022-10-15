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
    private val fetchDomainModelUseCase: dagger.Lazy<UseCase<MenuItemsContainer>>,
    private val fetchBannersUseCase: dagger.Lazy<UseCase<BannersContainer>>,
    private val fetchCategoriesUseCase: dagger.Lazy<UseCase<CategoriesContainer>>
) : ViewModel() {

    private val _bannersLiveData = MutableLiveData<BannersContainer>()
    val bannersLiveData: LiveData<BannersContainer> get() = _bannersLiveData

    private val _categoriesLiveData = MutableLiveData<CategoriesContainer>()
    val categoriesLiveData: LiveData<CategoriesContainer> get() = _categoriesLiveData

    private val _menuItemsLiveData = MutableLiveData<MenuItemsContainer>()
    val menuItemsLiveData: LiveData<MenuItemsContainer> get() = _menuItemsLiveData

    private val _errorStatusLiveData = MutableLiveData<Boolean>()
    val errorStatusLiveData: LiveData<Boolean> get() = _errorStatusLiveData

    fun fetchDisplayableItems() {
        CoroutineScope(context = Dispatchers.IO).launch {
            try {
                _categoriesLiveData.postValue(fetchCategoriesUseCase.get().execute())
                _bannersLiveData.postValue(fetchBannersUseCase.get().execute())
                _menuItemsLiveData.postValue(fetchDomainModelUseCase.get().execute())
            } catch (e: Exception) {
                _errorStatusLiveData.postValue(true)
            }
        }
    }

    @Suppress("UNCHECKED_CAST") class Factory @Inject constructor(
        private val fetchDomainModelUseCase: dagger.Lazy<UseCase<MenuItemsContainer>>,
        private val fetchBannersUseCase: dagger.Lazy<UseCase<BannersContainer>>,
        private val fetchCategoriesUseCase: dagger.Lazy<UseCase<CategoriesContainer>>
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
