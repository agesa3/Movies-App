package com.beatrice.moviesapp.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beatrice.moviesapp.data.MovieRepository
import com.beatrice.moviesapp.network.util.NetworkResult
import com.beatrice.moviesapp.presentaion.model.MoviesViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import logcat.logcat
import javax.annotation.meta.When
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _movieViewState: MutableStateFlow<MoviesViewState> =
        MutableStateFlow(MoviesViewState.Loading)
    val moviesViewState: StateFlow<MoviesViewState> = _movieViewState.asStateFlow()

    fun getPopularMovies() {
        viewModelScope.launch(ioDispatcher) {
            movieRepository.getPopularMovies().collect{ result ->
                when(result){
                    is NetworkResult.Success -> {
                        _movieViewState.value = MoviesViewState.MoviesList(movies = result.data)
                    }
                    is NetworkResult.Error -> {
                        _movieViewState.value = MoviesViewState.Error(message = "TODO: fix")
                    }
                    is NetworkResult.Exception -> {
                        _movieViewState.value = MoviesViewState.Error(message = "TODO: fix")
                    }
                }
            }
        }
    }
}