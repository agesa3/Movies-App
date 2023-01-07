package com.beatrice.moviesapp.core.network.datasource

import com.beatrice.moviesapp.core.network.ApiService
import com.beatrice.moviesapp.core.network.model.MovieNetworkResult
import com.beatrice.moviesapp.core.network.util.handleApi
import javax.inject.Inject

class MoviesDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun getPopularMovies(): Result<MovieNetworkResult?> = handleApi {
        apiService.getPopularMovies()
    }
}