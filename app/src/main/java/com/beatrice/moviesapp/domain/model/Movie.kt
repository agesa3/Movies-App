package com.beatrice.moviesapp.domain.model

import android.os.Parcelable
import com.beatrice.moviesapp.core.network.model.MovieNetworkResult
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
    val overview: String,
) : Parcelable

fun MovieNetworkResult.toMoviesList(): List<Movie> {
    return results?.map {
        Movie(
            id = it.id ?: 0,
            title = it.title ?: "",
            originalTitle = it.original_title ?: "",
            language = it.original_language ?: "",
            releaseDate = it.release_date ?: "",
            voteCount = it.vote_count ?: 0,
            voteAverage = it.vote_average ?: 0.0,
            popularity = it.popularity ?: 0.0,
            posterPath = it.poster_path ?: "",
            backdropPath = it.backdrop_path ?: "",
            overview = it.overview ?: ""
        )
    } ?: emptyList()
}



