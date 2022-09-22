package com.junwooyeom.composeapplication.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    fun getAllFilmsByFlow(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM MovieEntity")
    suspend fun getAllFilms(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(entity: MovieEntity)

    @Query("DELETE FROM MovieEntity WHERE id = :id")
    suspend fun deleteMovieById(id: String)
}
