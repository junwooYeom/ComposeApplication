package com.junwooyeom.composeapplication.domain

import kotlinx.coroutines.flow.zip
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */

class GetMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
){
    operator fun invoke() = movieRepository.getMovie()
}