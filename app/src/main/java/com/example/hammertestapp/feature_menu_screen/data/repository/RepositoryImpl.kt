package com.example.hammertestapp.feature_menu_screen.data.repository

import com.example.hammertestapp.core.utils.exceptions.ResponseIsNotSuccessfulException
import com.example.hammertestapp.core.utils.exceptions.ServerIsNotAvailableException
import com.example.hammertestapp.core.utils.mapper.Mapper
import com.example.hammertestapp.feature_menu_screen.data.network.models.Feed
import com.example.hammertestapp.feature_menu_screen.data.network.models.FoodResponse
import com.example.hammertestapp.feature_menu_screen.data.network.service.Service
import com.example.hammertestapp.feature_menu_screen.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @see Repository
 * */
internal class RepositoryImpl<DM> @Inject constructor(
    private val retrofitService: Service,
//    private val applicationContext: Context, // todo: move to di app context and replace this param to sharedPrefs instance?
    private val mapper: Mapper<@JvmSuppressWildcards FoodResponse, @JvmSuppressWildcards DM>
) : Repository<DM> {

    /**
     * @throws ServerIsNotAvailableException
     * @throws ResponseIsNotSuccessfulException
     * */
    suspend fun fetchDataFromInternet(): DM = withContext(Dispatchers.IO) {

        val response = try {
            retrofitService.fetchFoodResponse().also { retrofitResponse ->
                if (!retrofitResponse.isSuccessful) throw ResponseIsNotSuccessfulException()
            }.body()!!
        } catch (e: Exception) {
            throw ServerIsNotAvailableException()
        }
        return@withContext mapper.map(from = response)
    }

    suspend fun fetchDataFromStorage() = withContext(Dispatchers.IO) {

        return@withContext listOf<Feed>()
    }

    override suspend fun fetchData(): DM = withContext(Dispatchers.IO) {

        val response = try {
            retrofitService.fetchFoodResponse().also { retrofitResponse ->
                if (!retrofitResponse.isSuccessful) throw ResponseIsNotSuccessfulException()
            }.body()!!
        } catch (e: Exception) {
            throw ServerIsNotAvailableException()
        }
        return@withContext mapper.map(from = response)
    }

//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(Service::class.java)
//

//    }
}