package com.erick.buendia.disneyapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erick.buendia.disneyapp.data.database.dao.AmiiboDao
import com.erick.buendia.disneyapp.data.database.entity.AmiiboEntity

@Database(entities = [AmiiboEntity::class], version = 1)
abstract class AmiiboDataBase:RoomDatabase() {

    abstract fun getAmiiboDao(): AmiiboDao
}