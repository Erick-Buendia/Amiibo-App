package com.erick.buendia.disneyapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_amiibo_table")
data class FavoriteAmiiboEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "amiibo_id")
    val amiiboId: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "game_series")
    val gameSeries: String,
    @ColumnInfo(name = "character")
    val character: String,
    @ColumnInfo(name = "image")
    val image: String
)
