package com.beatrice.moviesapp.presentation.intent

sealed class MovieUiEvent {
    object GetPopularMovies: MovieUiEvent()
    object MarkFavorite: MovieUiEvent()
    object GetFavouriteMoviews: MovieUiEvent()
}