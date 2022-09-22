package com.junwooyeom.composeapplication.data

import com.junwooyeom.composeapplication.domain.NetworkResult
import com.junwooyeom.network.MovieDto
import com.junwooyeom.network.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
interface MovieRemoteDataSource {
    fun getMovie(): Flow<NetworkResult<List<MovieDto>>>

    fun getMovieById(id: String): Flow<NetworkResult<MovieDto>>
}

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi
): MovieRemoteDataSource {
    override fun getMovie(): Flow<NetworkResult<List<MovieDto>>> = flow {
        emit(NetworkResult.Loading)
        try {
            emit(NetworkResult.Success(api.getFilms()))
        } catch (e: Exception) {
            emit(NetworkResult.Error(e))
        }
    }


    override fun getMovieById(id: String): Flow<NetworkResult<MovieDto>> = flow {
        emit(NetworkResult.Loading)
        try {
            emit(NetworkResult.Success(api.getFilmById(id)))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e))
        }
    }
}