package com.beatrice.popularmovies.view.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.beatrice.popularmovies.view.components.ErrorMessageComponent
import com.beatrice.popularmovies.view.components.MoviesListComponent
import com.beatrice.popularmovies.view.components.ProgressIndicatorComponent
import com.beatrice.popularmovies.intent.MovieUiEvent
import com.beatrice.popularmovies.model.MoviesViewState
import com.beatrice.popularmovies.view.viewmodel.MoviesViewModel
import logcat.logcat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(
    moviesViewModel: MoviesViewModel = hiltViewModel(),
    navigateToMovieDetails: (movieId: Int) -> Unit = {}
) {
    val moviesState = moviesViewModel.moviesViewState.collectAsStateWithLifecycle().value

    LaunchedEffect(true) {
        moviesViewModel.movieUiEvents.send(MovieUiEvent.FetchPopularMovies)
    }

    Scaffold() { _ ->
        when (moviesState) {
            is MoviesViewState.Idle -> {
                logcat("STATE"){"idle"}
            }
            is MoviesViewState.Loading -> {
                ProgressIndicatorComponent()
            }
            is MoviesViewState.Data -> {
                MoviesListComponent(movieDomainModels = moviesState.movieDomainModels, navigateToMovieDetails = navigateToMovieDetails)
            }
            is MoviesViewState.Error -> {
                ErrorMessageComponent(message = moviesState.message)
            }
        }
    }
}

@Preview
@Composable
fun MoviesScreenPreview() {
    MovieScreen()
}
