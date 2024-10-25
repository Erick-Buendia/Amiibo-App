package com.erick.buendia.disneyapp.domain

import com.erick.buendia.disneyapp.data.FavoriteAmbiiboRepository
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import javax.inject.Inject


class GetFavoriteAmiiboUseCase @Inject constructor(private val repository: FavoriteAmbiiboRepository) {

    suspend operator fun invoke(): List<AmiiboModel> {
        return repository.getFavoriteAmiibo()
    }
}