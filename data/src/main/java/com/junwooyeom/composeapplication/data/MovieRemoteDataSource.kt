package com.junwooyeom.composeapplication.data

import com.junwooyeom.network.MovieDto
import com.junwooyeom.network.MovieApi
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
interface MovieRemoteDataSource {
    suspend fun getMovie(): List<MovieDto>

    suspend fun getMovieById(id: String): MovieDto
}

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi
): MovieRemoteDataSource {
    override suspend fun getMovie(): List<MovieDto> = api.getFilms()


    override suspend fun getMovieById(id: String): MovieDto = api.getFilmById(id)
}