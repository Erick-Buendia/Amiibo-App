package com.erick.buendia.disneyapp.data.network

import com.erick.buendia.disneyapp.core.retrofit.RetrofitHelper
import com.erick.buendia.disneyapp.data.model.Amiibo
import com.erick.buendia.disneyapp.data.model.AmiiboResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AmiiboService {

    suspend fun getAmiibo(): AmiiboResponse {
        return withContext(Dispatchers.IO) {
            val response = RetrofitHelper.provideRetrofit().create(AmiiboApiClient::class.java)
                .getAllAmiibo()
            response.body()!!
        }

    }
}