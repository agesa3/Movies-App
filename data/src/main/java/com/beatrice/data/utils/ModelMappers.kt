package com.beatrice.data.utils

import com.beatrice.database.model.MovieEntity
import com.beatrice.network.model.MoviesResponse
import com.beatrie.domain.models.MovieDomainModel

fun MoviesResponse.toMovieEntityList() =
    results?.map {
        MovieEntity(
            id =  it.id ?: 0,
            releaseDate = it.release_date ?: "" ,
            title = it.title ?:"",
            originalTitle = it.original_title ?:"",
            language =  it.original_language ?:"",
            popularity = it.popularity ?: 0.0,
            posterPath = it.poster_path ?:"",
            voteCount = it.vote_count ?: 0,
            voteAverage =  it.vote_average ?: 0.0,
            backdropPath =  it.backdrop_path ?: "",
            overview = it.overview ?:"",
            tag = null
        )
    }

fun List<MovieEntity>.toMoviesList() =
    this.map {
        MovieDomainModel(
            id = it.id,
            title = it.title,
            posterPath = it.posterPath,
            backdropPath = it.backdropPath,
            voteAverage = it.voteAverage,
            voteCount = it.voteCount,
            tag =  it.tag,
            releaseDate = it.releaseDate,
            language = it.language,
            popularity = it.popularity,
            originalTitle = it.originalTitle,
            overview = it.overview

        )
    }
