package com.junwooyeom.composeapplication.data

import com.junwooyeom.composeapplication.domain.Movie
import com.junwooyeom.composeapplication.domain.MovieRepository
import com.junwooyeom.composeapplication.domain.NetworkResult
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource,
) : MovieRepository {
    override val favoriteListFlow: Flow<List<Movie>>
        get() = localDataSource.getMoviesByFlow().map { it.map { data -> data.toMovie() } }

    override fun getMovie(): Flow<NetworkResult<List<Movie>>> = remoteDataSource.getMovie().transform { value ->
        value.let {
            when (it) {
                is NetworkResult.Success -> NetworkResult.Success(it.value.map { item -> item.toMovie() })
                is NetworkResult.Loading -> NetworkResult.Loading
                is NetworkResult.Error -> NetworkResult.Error(it.exception)
            }
        }
    }

    override fun getMovieById(id: String): Flow<NetworkResult<Movie>> = remoteDataSource.getMovieById(id).transform { value ->
        value.let {
            when (it) {
                is NetworkResult.Success -> NetworkResult.Success(it.value.toMovie())
                is NetworkResult.Loading -> NetworkResult.Loading
                is NetworkResult.Error -> NetworkResult.Error(it.exception)
            }
        }
    }
    override suspend fun insertMovie(movie: Movie) = localDataSource.insertMovie(movie.toMovieEntity())

    override suspend fun deleteMovie(movie: Movie) = localDataSource.deleteMovie(movie.id)
}