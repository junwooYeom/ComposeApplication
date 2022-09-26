package com.junwooyeom.composeapplication.domain

import androidx.annotation.Keep
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.Serializable

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
@Keep
data class Movie(
    val id: String,
    val title: String,
    val originTitle: String,
    val image: String,
    val description: String,
    val director: String,
    val releaseDate: String,
    val runningTime: String,
    val score: String,
    val url: String,
): Serializable {
    val isFavorite: MutableStateFlow<Boolean> = MutableStateFlow(false)
}