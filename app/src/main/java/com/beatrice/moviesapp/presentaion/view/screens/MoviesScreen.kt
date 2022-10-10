package com.beatrice.moviesapp.presentaion.view.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beatrice.moviesapp.presentaion.model.MoviesViewState
import com.beatrice.moviesapp.presentaion.view.components.ErrorMessageComponent
import com.beatrice.moviesapp.presentaion.view.components.MoviesListComponent
import com.beatrice.moviesapp.presentaion.view.components.ProgressIndicatorComponent
import com.beatrice.moviesapp.presentaion.view.components.movieList
import com.beatrice.moviesapp.presentaion.viewmodel.MoviesViewModel
import logcat.logcat

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun MovieScreen(moviesViewModel: MoviesViewModel = hiltViewModel()) {
    val moviesState = moviesViewModel.moviesViewState.collectAsStateWithLifecycle().value

    LaunchedEffect(true){
        logcat("SOLOONG"){"To get here"}
        moviesViewModel.getPopularMovies()
    }
    Scaffold(
        topBar = { /** TODO: Complete this*/ },

        ) { paddingValues ->
        MoviesListComponent(movies = movieList)
//        when (moviesState) { // TODO: Undo
//            is MoviesViewState.Loading -> {
//                ProgressIndicatorComponent()
//            }
//            is MoviesViewState.MoviesList -> {
//                MoviesListComponent(movies = moviesState.movies)
//            }
//            is MoviesViewState.Error -> {
//                ErrorMessageComponent(
//                    message = moviesState.message,
//
//                )
//            }
//        }
    }

}

@Preview
@Composable
fun MoviesScreenPreview() {
    MovieScreen()
}
