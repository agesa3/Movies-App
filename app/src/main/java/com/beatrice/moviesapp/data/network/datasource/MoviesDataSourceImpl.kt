package com.beatrice.moviesapp.data.network.datasource

import com.beatrice.moviesapp.data.network.ApiService
import com.beatrice.moviesapp.data.network.model.MovieNetworkResult
import com.beatrice.moviesapp.data.network.util.NetworkResult
import com.beatrice.moviesapp.data.network.util.handleApi
import javax.inject.Inject

class MoviesDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult> =
        handleApi { apiService.getPopularMovies() }
}