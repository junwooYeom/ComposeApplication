package com.junwooyeom.composeapplication.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    fun getAllFilms(): Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(entity: MovieEntity)

    @Query("DELETE FROM MovieEntity WHERE id = :id")
    suspend fun deleteMovieById(id: String)
}
