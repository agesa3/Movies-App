package com.beatrice.moviesapp.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import com.beatrice.moviesapp.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    fun test(){
        movieRepository.getMovies()
    }
}