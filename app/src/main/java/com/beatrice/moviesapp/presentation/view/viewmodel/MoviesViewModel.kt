package com.beatrice.moviesapp.presentation.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beatrice.moviesapp.data.MovieRepository
import com.beatrice.moviesapp.presentation.view.network.util.NetworkResult
import com.beatrice.moviesapp.presentation.intent.MovieUiEvent
import com.beatrice.moviesapp.presentation.model.MoviesViewState
import com.beatrice.moviesapp.presentation.util.TimeCapsule
import com.beatrice.moviesapp.presentation.util.TimeTravelCapsule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _movieViewState: MutableStateFlow<MoviesViewState> =
        MutableStateFlow(MoviesViewState.Loading)
    val moviesViewState: StateFlow<MoviesViewState> = _movieViewState.asStateFlow()

    val movieUiEvents = Channel<MovieUiEvent>(Channel.BUFFERED)

    val timeCapsule: TimeCapsule<MoviesViewState> = TimeTravelCapsule { storedState ->
        _movieViewState.tryEmit(storedState)
    }

    init {
        handleIntent()
    }

    fun handleIntent() {
        viewModelScope.launch {
            movieUiEvents.consumeAsFlow().collect { uiEvent ->
                when (uiEvent) {
                    is MovieUiEvent.GetPopularMovies -> getPopularMovies()
                    is MovieUiEvent.GetFavouriteMoviews -> getFavouriteMovies()
                    is MovieUiEvent.MarkFavorite -> markFavourite()
                }
            }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch(ioDispatcher) {
            movieRepository.getPopularMovies().collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        val newState = MoviesViewState.MoviesList(movies = result.data)
                        timeCapsule.addState(newState)
                        _movieViewState.value =  newState
                    }
                    is NetworkResult.Error -> {
                        val newState = MoviesViewState.Error(message = "TODO: Put appropriate message")
                        _movieViewState.value = newState
                        timeCapsule.addState(newState)

                    }
                    is NetworkResult.Exception -> {
                        val newState = MoviesViewState.Error(message = "TODO: Put appropriate message")
                        _movieViewState.value = newState
                        timeCapsule.addState(newState)

                    }
                }
            }
        }
    }

    private fun getFavouriteMovies(){

    }

    private fun markFavourite(){

    }
}