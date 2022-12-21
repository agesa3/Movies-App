package com.beatrice.moviesapp.core.network.datasource

import com.beatrice.moviesapp.core.network.model.MovieNetworkResult
import com.beatrice.moviesapp.core.network.util.NetworkResult

interface MoviesDataSource {
    suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult>
}