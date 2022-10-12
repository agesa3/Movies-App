package com.beatrice.moviesapp.presentaion.intent

sealed class MovieUiEvent {
    object GetPopularMovies: MovieUiEvent()
}