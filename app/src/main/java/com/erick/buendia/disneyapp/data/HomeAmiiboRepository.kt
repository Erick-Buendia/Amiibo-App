package com.erick.buendia.disneyapp.data

import android.util.Log
import com.erick.buendia.disneyapp.data.database.dao.AmiiboDao
import com.erick.buendia.disneyapp.data.database.dao.FavoriteDao
import com.erick.buendia.disneyapp.data.database.entity.AmiiboEntity
import com.erick.buendia.disneyapp.data.database.entity.toDomain
import com.erick.buendia.disneyapp.data.model.toDomain
import com.erick.buendia.disneyapp.data.network.AmiiboService
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import javax.inject.Inject

class HomeAmiiboRepository @Inject constructor(
    private val homeAmiibo: AmiiboService,
    private val amiiboDao: AmiiboDao,
    private val favoriteAmiiboDao: FavoriteDao
) {

    suspend fun getAmiiboListApi(): List<AmiiboModel> {
        runCatching { homeAmiibo.getAllAmiibo() }
            .onSuccess {
                val amiiboDao = it.amiibo.map { it.toDomain() }
                amiiboDao.map {
                    if (favoriteAmiiboDao.findByIdAmiibo(it.amiiboId) != null) it.isFavorite = true
                }
                return amiiboDao
            }.onFailure {
                Log.i("ErrorNewsApi", it.message.toString())
            }
        return emptyList()
    }

    suspend fun getAmiiboListDataBase(): List<AmiiboModel> {
        runCatching { amiiboDao.getAllAmiibo() }
            .onSuccess {
                val amiiboDao = it.map { it.toDomain() }
                amiiboDao.map {
                    if (favoriteAmiiboDao.findByIdAmiibo(it.amiiboId) != null) it.isFavorite = true
                }
                return amiiboDao
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