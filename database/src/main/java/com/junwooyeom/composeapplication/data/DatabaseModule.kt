package com.junwooyeom.composeapplication.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "database_private.db").build()

    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao()

}
