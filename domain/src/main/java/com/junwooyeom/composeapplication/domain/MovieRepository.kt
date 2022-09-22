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

    suspend fun getMovie(): List<Movie>

    suspend fun getMovieById(id: String): Movie

    suspend fun insertMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)
}