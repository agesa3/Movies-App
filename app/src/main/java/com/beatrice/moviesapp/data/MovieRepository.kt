package com.beatrice.moviesapp.data

interface MovieRepository {
    suspend fun getPopularMovies()
}