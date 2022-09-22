package com.junwooyeom.composeapplication.domain

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
sealed class NetworkResult<out T> {
    data class Success<out T>(val value: T): NetworkResult<T>()
    object Loading: NetworkResult<Nothing>()
    data class Error(val exception: Throwable? = null): NetworkResult<Nothing>()
}