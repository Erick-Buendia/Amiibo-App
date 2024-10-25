package com.erick.buendia.disneyapp.core.room

import android.content.Context
import androidx.room.Room
import com.erick.buendia.disneyapp.data.database.AmiiboDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    const val DATABASE_NAME = "amiibo_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, AmiiboDataBase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideAmiiboDao(db: AmiiboDataBase) = db.getAmiiboDao()

}