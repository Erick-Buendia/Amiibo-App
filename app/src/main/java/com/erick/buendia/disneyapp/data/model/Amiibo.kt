package com.erick.buendia.disneyapp.data.model
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import com.google.gson.annotations.SerializedName

data class Amiibo(
    @SerializedName("amiiboSeries")
    val amiiboSeries: String,
    @SerializedName("character")
    val character: String,
    @SerializedName("gameSeries")
    val gameSeries: String,
    @SerializedName("head")
    val head: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("tail")
    val tail: String,
    @SerializedName("type")
    val type: String
)
fun Amiibo.toDomain(): AmiiboModel {
    return AmiiboModel("$head$tail",name, gameSeries, character, image)
}


