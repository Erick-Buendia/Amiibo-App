package com.erick.buendia.disneyapp.core.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.amiiboapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}