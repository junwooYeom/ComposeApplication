package com.junwooyeom.composeapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "origin_title")
    val originTitle: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "director")
    val director: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    @ColumnInfo(name = "running_time")
    val runningTime: String,
    @ColumnInfo(name = "rt_score")
    val score: String,
    @ColumnInfo(name = "url")
    val url: String,
)
