package com.beatrice.moviesapp.presentation.view.network.datasource

import com.beatrice.moviesapp.presentation.view.network.model.MovieNetworkResult
import com.beatrice.moviesapp.presentation.view.network.util.NetworkResult

interface MoviesDataSource {
    suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult>
}