package com.beatrice.moviesapp.network.datasource

import com.beatrice.moviesapp.network.ApiService
import com.beatrice.moviesapp.network.model.MovieNetworkResult
import com.beatrice.moviesapp.network.util.NetworkResult
import com.beatrice.moviesapp.network.util.handleApi
import javax.inject.Inject

class MoviesDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult> =
        handleApi { apiService.getPopularMovies() }
}