package com.erick.buendia.disneyapp.domain

import com.erick.buendia.disneyapp.data.HomeAmiiboRepositoryImpl
import com.erick.buendia.disneyapp.domain.model.AmiiboModel

class GetHomeAmiiboUseCase {

    private val repository = HomeAmiiboRepositoryImpl()

    suspend operator fun invoke(): List<AmiiboModel> {
        return repository.getAmiiboList()

    }
}