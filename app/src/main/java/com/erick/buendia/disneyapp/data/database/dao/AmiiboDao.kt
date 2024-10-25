package com.erick.buendia.disneyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.erick.buendia.disneyapp.data.database.entity.AmiiboEntity

@Dao
interface AmiiboDao {

    @Query("SELECT * FROM amiibo_table ORDER BY id DESC")
    suspend fun getAllAmiibo(): List<AmiiboEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(amiibo: List<AmiiboEntity>)

    @Query("DELETE FROM amiibo_table")
    suspend fun deleteAllAmiibo()


}