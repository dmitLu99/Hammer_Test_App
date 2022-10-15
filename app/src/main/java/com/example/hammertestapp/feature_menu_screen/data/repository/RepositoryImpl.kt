package com.example.hammertestapp.feature_menu_screen.data.repository

import com.example.hammertestapp.core.utils.exceptions.ResponseIsNotSuccessfulException
import com.example.hammertestapp.core.utils.exceptions.ServerIsNotAvailableException
import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.data.network.service.Service
import com.example.hammertestapp.feature_menu_screen.data.storage.database.MenuDatabase
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.FeedEntity
import com.example.hammertestapp.feature_menu_screen.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @see Repository
 * */
internal class RepositoryImpl<DM> @Inject constructor(
    private val retrofitService: Service,
    private val database: MenuDatabase,
    private val feedMapper: Mapper<@JvmSuppressWildcards List<FeedEntity>, @JvmSuppressWildcards DM>,
    private val responseToEntitiesMapper: Mapper<@JvmSuppressWildcards FoodResponse, @JvmSuppressWildcards List<FeedEntity>>,
    private val responseMapper: Mapper<@JvmSuppressWildcards FoodResponse, @JvmSuppressWildcards DM>
) : Repository<DM> {

    private var response: FoodResponse? = null

    /**
     * @throws ServerIsNotAvailableException
     * @throws ResponseIsNotSuccessfulException
     * */
    private suspend fun fetchDataFromInternet(): FoodResponse = withContext(Dispatchers.IO) {

        return@withContext try {
            retrofitService.fetchFoodResponse().also { retrofitResponse ->
                if (!retrofitResponse.isSuccessful) throw ResponseIsNotSuccessfulException()
            }.body()!!
        } catch (e: Exception) {
            throw ServerIsNotAvailableException()
        }
    }

    override suspend fun fetchData(): DM = withContext(Dispatchers.IO) {

        if (response != null) return@withContext responseMapper.map(from = response!!)

        response = try {
            fetchDataFromInternet()
        } catch (e: Exception) {
            return@withContext feedMapper.map(from = database.feedDao().getFeeds())
        }

        database.clearAllTables()

        responseToEntitiesMapper.map(from = response!!).forEach { feed ->
            database.feedDao().insertFeed(feed = feed)
        }

        return@withContext responseMapper.map(from = response!!)
    }
}