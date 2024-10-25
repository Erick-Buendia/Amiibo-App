package com.erick.buendia.disneyapp.data.network

import com.erick.buendia.disneyapp.data.model.AmiiboResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AmiiboService @Inject constructor(private val api: AmiiboApiClient) {

    suspend fun getAllAmiibo(): AmiiboResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllAmiibo()
            response.body()!!
        }
    }
}