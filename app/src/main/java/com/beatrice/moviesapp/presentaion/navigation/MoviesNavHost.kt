package com.beatrice.moviesapp.presentaion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.beatrice.moviesapp.presentaion.view.screens.MovieDetailScreen
import com.beatrice.moviesapp.presentaion.view.screens.MovieScreen
import com.beatrice.moviesapp.presentaion.view.screens.movie


@Composable
fun MoviesNavHost(
    navController: NavHostController,
    startDestination: String = Screens.MoviesScreen.route
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screens.MoviesScreen.route) {
            MovieScreen(
                navigateToMovieDetails = { movieId ->
                    val route = Screens.MovieDetailScreen.createRoute(movieId = movieId)
                    navController.navigate(route)
                }
            )
        }
        composable(Screens.MovieDetailScreen.route) {backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            requireNotNull(movieId) { "movieId parameter wasn't found" }
            MovieDetailScreen(movieId = movieId.toInt())
        }
    }
}
