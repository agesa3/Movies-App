package com.beatrice.moviesapp.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beatrice.moviesapp.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {// Inject the dispatcher
            movieRepository.getPopularMovies()
        }
    }
}