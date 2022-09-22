package com.junwooyeom.composeapplication.domain

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
}