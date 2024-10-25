package com.erick.buendia.disneyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.erick.buendia.disneyapp.data.database.entity.FavoriteAmiiboEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_amiibo_table")
    suspend fun getAllFavoriteAmiibo(): List<FavoriteAmiiboEntity>


    @Query("SELECT * FROM favorite_amiibo_table WHERE amiibo_id = :id")
    suspend fun findByIdAmiibo(id: String): FavoriteAmiiboEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteAmiibo(amiibo: FavoriteAmiiboEntity)

    @Query("DELETE FROM favorite_amiibo_table WHERE amiibo_id = :id")
    suspend fun deleteFavoriteAmiibo(id: String)




}