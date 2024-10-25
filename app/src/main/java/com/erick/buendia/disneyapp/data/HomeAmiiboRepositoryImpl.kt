package com.erick.buendia.disneyapp.data

import android.util.Log
import com.erick.buendia.disneyapp.data.database.dao.AmiiboDao
import com.erick.buendia.disneyapp.data.database.entity.AmiiboEntity
import com.erick.buendia.disneyapp.data.database.entity.toDomain
import com.erick.buendia.disneyapp.data.model.toDomain
import com.erick.buendia.disneyapp.data.network.AmiiboService
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import javax.inject.Inject

class HomeAmiiboRepositoryImpl @Inject constructor(
    private val homeAmiiboDao: AmiiboService,
    private val amiiboDao: AmiiboDao
) {

    suspend fun getAmiiboListApi(): List<AmiiboModel> {
        runCatching { homeAmiiboDao.getAllAmiibo() }
            .onSuccess {
                return it.amiibo.map { it.toDomain() }
            }.onFailure {
                Log.i("ErrorNewsApi", it.message.toString())
            }
        return emptyList()
    }

    suspend fun getAmiiboListDataBase(): List<AmiiboModel> {
        runCatching { amiiboDao.getAllAmiibo() }
            .onSuccess {
                return it.map { it.toDomain() }
            }.onFailure {
                Log.i("ErrorDataBase", it.message.toString())
            }
        return emptyList()
    }

    suspend fun insertAmiibo(amiibo: List<AmiiboEntity>) {
        amiiboDao.insertAll(amiibo)
    }

    suspend fun clearAmiibo() {
        amiiboDao.deleteAllAmiibo()
    }


}