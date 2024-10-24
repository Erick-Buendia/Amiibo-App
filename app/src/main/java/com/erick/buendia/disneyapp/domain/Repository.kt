package com.erick.buendia.disneyapp.domain

import com.erick.buendia.disneyapp.domain.model.AmiiboModel


interface Repository {

    suspend fun getAmiiboList(): AmiiboModel?
}