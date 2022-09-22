package com.junwooyeom.composeapplication.domain

import kotlinx.coroutines.flow.Flow

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
interface MovieRepository {

    val favoriteListFlow: Flow<List<Movie>>

    fun getMovie(): Flow<NetworkResult<List<Movie>>>

    fun getMovieById(id: String): Flow<NetworkResult<Movie>>

    suspend fun insertMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)
}