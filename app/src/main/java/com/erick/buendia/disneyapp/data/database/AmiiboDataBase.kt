package com.erick.buendia.disneyapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erick.buendia.disneyapp.data.database.dao.AmiiboDao
import com.erick.buendia.disneyapp.data.database.dao.FavoriteDao
import com.erick.buendia.disneyapp.data.database.entity.AmiiboEntity
import com.erick.buendia.disneyapp.data.database.entity.FavoriteAmiiboEntity

@Database(entities = [AmiiboEntity::class, FavoriteAmiiboEntity::class], version = 2)
abstract class AmiiboDataBase : RoomDatabase() {

    abstract fun getAmiiboDao(): AmiiboDao
    abstract fun getFavoriteDao(): FavoriteDao
}