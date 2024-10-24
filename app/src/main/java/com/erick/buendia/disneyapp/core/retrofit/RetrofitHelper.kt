package com.erick.buendia.disneyapp.core.retrofit

import com.erick.buendia.disneyapp.data.network.AmiiboApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.amiiboapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAmiiboApiClient(retrofit: Retrofit): AmiiboApiClient {
        return retrofit.create(AmiiboApiClient::class.java)
    }

}