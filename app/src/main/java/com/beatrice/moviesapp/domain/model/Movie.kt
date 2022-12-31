package com.beatrice.moviesapp.domain.model

import android.os.Parcelable
import com.beatrice.moviesapp.core.database.model.MovieEntity
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





