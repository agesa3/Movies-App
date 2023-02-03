package com.beatrice.popularmovies.intent

sealed class MovieUiEvent {
    object FetchPopularMovies : MovieUiEvent()
    object MarkFavorite : MovieUiEvent()
    object FetchFavouriteMovies : MovieUiEvent()
}
