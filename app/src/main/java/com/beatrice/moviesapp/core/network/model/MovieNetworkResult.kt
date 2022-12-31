package com.beatrice.moviesapp.core.network.model

import com.beatrice.moviesapp.core.database.model.MovieEntity

data class MovieNetworkResult(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun MovieNetworkResult.toMovieEntityList(): List<MovieEntity> {
    return results?.map {
        MovieEntity(
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
            overview = it.overview ?: "",
            tag = null
        )
    } ?: emptyList()
}