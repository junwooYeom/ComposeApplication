package com.junwooyeom.composeapplication.data

import com.junwooyeom.composeapplication.database.MovieEntity
import com.junwooyeom.composeapplication.domain.Movie
import com.junwooyeom.network.MovieDto
import java.util.*

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */

fun MovieDto.toMovie(): Movie =
    Movie(
        id = id,
        title = title,
        originTitle = if (Locale.getDefault() == Locale.JAPAN) originalTitle else originalTitleRomanised,
        image = image,
        director = director,
        description = description,
        releaseDate = releaseDate,
        runningTime = runningTime,
        score = score,
        url = url
    )

fun MovieEntity.toMovie(): Movie =
    Movie(
        id = id,
        title = title,
        originTitle = originTitle,
        image = image,
        description = description,
        director = director,
        releaseDate = releaseDate,
        runningTime = runningTime,
        score = score,
        url = url
    )

fun Movie.toMovieEntity(): MovieEntity =
    MovieEntity(
        id = id,
        title = title,
        originTitle = originTitle,
        image = image,
        description = description,
        director = director,
        releaseDate = releaseDate,
        runningTime = runningTime,
        score = score,
        url = url
    )