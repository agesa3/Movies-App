package com.beatrice.moviesapp.presentation.view.network.datasource

import com.beatrice.moviesapp.presentation.view.network.ApiService
import com.beatrice.moviesapp.presentation.view.network.model.MovieNetworkResult
import com.beatrice.moviesapp.presentation.view.network.util.NetworkResult
import com.beatrice.moviesapp.presentation.view.network.util.handleApi
import javax.inject.Inject

class MoviesDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MoviesDataSource {

    override suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult> =
        handleApi { apiService.getPopularMovies() }
}