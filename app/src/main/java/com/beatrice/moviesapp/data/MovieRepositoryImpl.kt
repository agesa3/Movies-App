package com.beatrice.moviesapp.data

import com.beatrice.moviesapp.database.dao.MovieDao
import com.beatrice.moviesapp.network.ApiService
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val apiService: ApiService
) : MovieRepository {
    override suspend fun getPopularMovies() {
        val result = apiService.getPopularMovies()
    }
}