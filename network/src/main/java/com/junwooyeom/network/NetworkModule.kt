package com.junwooyeom.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val MOVIE_URL = "https://ghibliapi.herokuapp.com"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MOVIE_URL)
            .build()

    @Provides
    @Singleton
    fun providesMovieService(retrofit: Retrofit): MovieApi = retrofit.create()
}
