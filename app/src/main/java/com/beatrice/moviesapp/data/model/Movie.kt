package com.beatrice.moviesapp.data.model

import com.beatrice.moviesapp.network.model.MovieNetworkResult

data class Movie(
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

fun MovieNetworkResult.toMoviesList(): List<Movie> =results.map {
        Movie(
            title = it.title,
            originalTitle = it.original_title,
            language = it.original_language,
            releaseDate = it.release_date,
            voteAverage = it.vote_average,
            voteCount = it.vote_count,
            popularity = it.popularity,
            posterPath = it.poster_path,
            backdropPath = it.backdrop_path,
            overview = it.overview

        )
    }.toList()



