package com.capri.composeapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junwooyeom.composeapplication.domain.GetMovieUseCase
import com.junwooyeom.composeapplication.domain.Movie
import com.junwooyeom.composeapplication.domain.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/26
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    getMovieUseCase: GetMovieUseCase
): ViewModel(){
    private val movieFlow = getMovieUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            NetworkResult.Loading
        )

    val movieListFlow = movieFlow.map {
        if (it is NetworkResult.Success) {
            it.value
        } else {
            listOf()
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        listOf()
    )
}