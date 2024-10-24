package com.erick.buendia.disneyapp.data.model

import com.erick.buendia.disneyapp.domain.model.AmiiboModel

data class AmiiboResponse(
    val amiibo: List<Amiibo>
){
    fun toDomain(): List<AmiiboModel> {
        return amiibo.map {
            AmiiboModel(
                name = it.name,
                gameSeries = it.gameSeries,
                character = it.character,
                image = it.image
            )
        }
    }

}