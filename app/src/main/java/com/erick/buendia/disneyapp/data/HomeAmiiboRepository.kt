package com.erick.buendia.disneyapp.data

import android.util.Log
import com.erick.buendia.disneyapp.data.model.Amiibo
import com.erick.buendia.disneyapp.data.network.AmiiboService

class HomeAmiiboRepository {

    private val homeAmiiboDao = AmiiboService()


    suspend fun getAmiiboList(): List<Amiibo> {
        runCatching { homeAmiiboDao.getAmiibo() }
            .onSuccess {
                return it.amiibo ?: emptyList()
            }.onFailure {
                Log.i("ErrorNewsApi", it.message.toString())
            }
        return emptyList()
    }


}