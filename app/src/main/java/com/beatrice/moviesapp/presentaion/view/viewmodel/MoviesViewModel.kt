package com.beatrice.moviesapp.presentaion.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beatrice.moviesapp.data.MovieRepository
import com.beatrice.moviesapp.network.util.NetworkResult
import com.beatrice.moviesapp.presentaion.intent.MovieUiEvent
import com.beatrice.moviesapp.presentaion.model.MoviesViewState
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

    init {
        handleIntent()
    }

    fun handleIntent() {
        viewModelScope.launch {
            movieUiEvents.consumeAsFlow().collect { uiEvent ->
                when (uiEvent) {
                    is MovieUiEvent.GetPopularMovies -> getPopularMovies()
                }
            }
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch(ioDispatcher) {
            movieRepository.getPopularMovies().collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _movieViewState.value = MoviesViewState.MoviesList(movies = result.data)
                    }
                    is NetworkResult.Error -> {
                        _movieViewState.value =
                            MoviesViewState.Error(message = "TODO: Put appropriate message")
                    }
                    is NetworkResult.Exception -> {
                        _movieViewState.value =
                            MoviesViewState.Error(message = "TODO: Put appropriate message")
                    }
                }
            }
        }
    }
}