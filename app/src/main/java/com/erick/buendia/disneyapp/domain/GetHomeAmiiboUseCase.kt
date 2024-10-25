package com.erick.buendia.disneyapp.domain

import com.erick.buendia.disneyapp.data.HomeAmiiboRepositoryImpl
import com.erick.buendia.disneyapp.data.database.entity.toDataBase
import com.erick.buendia.disneyapp.domain.model.AmiiboModel
import javax.inject.Inject


class GetHomeAmiiboUseCase @Inject constructor(private val repository: HomeAmiiboRepositoryImpl) {

    suspend operator fun invoke(): List<AmiiboModel> {

        val amiibo = repository.getAmiiboListApi()

        if (amiibo.isNotEmpty()) {
            repository.clearAmiibo()
            repository.insertAmiibo(amiibo.map { it.toDataBase() })
            return amiibo
        } else {
            return repository.getAmiiboListDataBase()
        }
    }
}