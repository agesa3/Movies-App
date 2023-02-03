package com.beatrice.popularmovies.model

import android.os.Parcelable
import com.beatrie.domain.models.MovieDomainModel
import kotlinx.parcelize.Parcelize

sealed class MoviesViewState : Parcelable {
    @Parcelize
    object Idle : MoviesViewState()
    @Parcelize
    object Loading : MoviesViewState()
    @Parcelize
    data class Data(val movieDomainModels: List<MovieDomainModel>) : MoviesViewState()
    @Parcelize
    data class Error(val message: String) : MoviesViewState()
}
