package com.beatrice.moviesapp.presentation.model

import com.beatrice.moviesapp.data.model.Movie

sealed class MoviesViewState {
    object Loading: MoviesViewState()
    data class MoviesList(val movies: List<Movie>): MoviesViewState()
    data class Error(val message: String): MoviesViewState()
}