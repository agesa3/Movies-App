package com.beatrice.moviesapp.presentation.intent

sealed class MovieUiEvent {
    object FetchPopularMovies: MovieUiEvent()
    object MarkFavorite: MovieUiEvent()
    object FetchFavouriteMovies: MovieUiEvent()
}
