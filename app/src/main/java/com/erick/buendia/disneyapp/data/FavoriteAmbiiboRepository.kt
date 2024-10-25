package com.erick.buendia.disneyapp.data

import com.erick.buendia.disneyapp.data.database.dao.AmiiboDao
import com.erick.buendia.disneyapp.data.database.dao.FavoriteDao
import com.erick.buendia.disneyapp.data.database.entity.AmiiboEntity
import com.erick.buendia.disneyapp.data.database.entity.toDomain
import com.erick.buendia.disneyapp.data.database.entity.toDomainFavorite
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import javax.inject.Inject

class FavoriteAmbiiboRepository @Inject constructor(private val amiiboDao: AmiiboDao, private val favoriteAmiiboDao: FavoriteDao) {


    suspend fun getFavoriteAmiibo(): List<AmiiboModel> {

        return favoriteAmiiboDao.getAllFavoriteAmiibo().map { it.toDomain() }
    }

    suspend fun findByIdAmiiboDataBase(id: String): AmiiboEntity {
        return amiiboDao.findByIdAmiibo(id)
    }

    suspend fun addFavoriteAmiibo(amiibo: AmiiboEntity) {
        favoriteAmiiboDao.insertFavoriteAmiibo(amiibo.toDomainFavorite())

    }

    suspend fun removeFavoriteAmiibo(id: String) {
        favoriteAmiiboDao.deleteFavoriteAmiibo(id)
    }

}