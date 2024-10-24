package com.erick.buendia.disneyapp.data.network

import com.erick.buendia.disneyapp.data.model.AmiiboResponse
import retrofit2.Response
import retrofit2.http.GET

interface AmiiboApiClient {

    //Peteciones a la  API
    @GET("amiibo")
    suspend fun getAllAmiibo(): Response<AmiiboResponse>
}