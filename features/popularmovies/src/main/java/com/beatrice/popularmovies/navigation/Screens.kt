package com.beatrice.moviesapp.presentation.navigation

sealed class Screens (val route: String){
    object MoviesScreen: Screens("/movies")
    object MovieDetailScreen: Screens("/movies/{movieId}"){
        fun createRoute(movieId: Int) = "/movies/$movieId"
    }

}