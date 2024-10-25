package com.erick.buendia.disneyapp.domain

import com.erick.buendia.disneyapp.data.FavoriteAmbiiboRepository
import javax.inject.Inject

class RemoveFavoriteAmiboUseCase @Inject constructor(private val repository: FavoriteAmbiiboRepository) {

    suspend operator fun invoke(id: String) {
        repository.removeFavoriteAmiibo(id)
    }

}