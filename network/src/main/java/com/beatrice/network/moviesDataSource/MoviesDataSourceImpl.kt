package com.beatrice.network.moviesDataSource

import com.beatrice.network.util.handleApi
import com.beatrice.network.ApiService
import com.beatrice.network.model.MoviesResponse
import javax.inject.Inject


class MoviesDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun getPopularMovies(): Result<MoviesResponse?> = handleApi {
        apiService.getPopularMovies()
    }
}