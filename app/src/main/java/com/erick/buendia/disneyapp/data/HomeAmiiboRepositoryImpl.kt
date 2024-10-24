package com.erick.buendia.disneyapp.data

import android.util.Log
import com.erick.buendia.disneyapp.data.network.AmiiboService
import com.erick.buendia.disneyapp.domain.model.AmiiboModel

class HomeAmiiboRepositoryImpl {

    private val homeAmiiboDao = AmiiboService()

    suspend fun getAmiiboList(): List<AmiiboModel> {
        runCatching { homeAmiiboDao.getAmiibo() }
            .onSuccess {
                return it.toDomain()
            }.onFailure {
                Log.i("ErrorNewsApi", it.message.toString())
            }
        return emptyList()
    }


}