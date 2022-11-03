package com.beatrice.moviesapp.data.model

import android.os.Parcelable
import com.beatrice.moviesapp.presentation.view.network.model.MovieNetworkResult
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
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
): Parcelable

fun MovieNetworkResult.toMoviesList(): List<Movie> =results.map {
        Movie(
            id = it.id,
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



