package com.beatrice.moviesapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val originalTitle: String,
    val language: String,
    val releaseDate: String,
    val voteCount: Int,
    val voteAverage: Double,
    val popularity: Double,
    val posterPath: String,
    val backdropPath: String,
    val overview: String
)
