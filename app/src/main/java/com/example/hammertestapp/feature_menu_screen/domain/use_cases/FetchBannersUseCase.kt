package com.example.hammertestapp.feature_menu_screen.domain.use_cases

import com.example.hammertestapp.core.use_case.UseCase
import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.core.utils.markers.DisplayableItem
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainBanner
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @see UseCase
 * */
internal class FetchBannersUseCase<DI : DisplayableItem> @Inject constructor(
    private val repository: Repository<DomainModel>,
    private val mapper: Mapper<@JvmSuppressWildcards List<DomainBanner>, @JvmSuppressWildcards DI>
) : UseCase<DI> {

    override suspend fun execute(): DI = withContext(Dispatchers.Default) {

        return@withContext mapper.map(from = repository.fetchData().banners)
    }
}