package com.erick.buendia.disneyapp.data.model

import com.google.gson.annotations.SerializedName

data class AmiiboResponse(
    @SerializedName("amiibo")
    val amiibo: List<Amiibo>
)