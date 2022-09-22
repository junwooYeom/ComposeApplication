package com.junwooyeom.network

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("/films")
    suspend fun getFilms(): List<MovieDto>

    @GET("/films/{id}")
    suspend fun getFilmById(@Path("id") id: String): MovieDto
}
