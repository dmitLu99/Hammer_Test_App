package com.example.hammertestapp.feature_menu_screen.domain.use_cases

import com.example.hammertestapp.core.use_case.UseCase
import com.example.hammertestapp.core.utils.exceptions.ResponseIsNotSuccessfulException
import com.example.hammertestapp.core.utils.exceptions.ServerIsNotAvailableException
import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.core.utils.markers.DisplayableItem
import com.example.hammertestapp.feature_menu_screen.domain.models.DomainModel
import com.example.hammertestapp.feature_menu_screen.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @see UseCase
 * */
internal class FetchDomainModelUseCase<DI : DisplayableItem> @Inject constructor(
    private val repository: Repository<DomainModel>,
    private val mapper: Mapper<@JvmSuppressWildcards DomainModel, @JvmSuppressWildcards DI>
) : UseCase<DI> {

    override suspend fun execute(): DI = withContext(Dispatchers.Default) {

        val domainModel = try {
            // todo: storage & network logic
            repository.fetchData()
        } catch (e: ServerIsNotAvailableException) {
            // todo
            throw RuntimeException()
        } catch (e: ResponseIsNotSuccessfulException) {
            // todo
            throw RuntimeException()
        }

        return@withContext mapper.map(from = domainModel)
    }
}