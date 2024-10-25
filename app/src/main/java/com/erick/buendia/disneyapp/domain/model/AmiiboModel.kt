package com.erick.buendia.disneyapp.domain.model

data class AmiiboModel(
    val amiiboId: String,
    val name: String,
    val gameSeries: String,
    val character: String,
    val image: String,
    var isFavorite: Boolean = false
)
