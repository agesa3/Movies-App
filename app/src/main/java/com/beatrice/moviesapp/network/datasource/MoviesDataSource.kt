package com.beatrice.moviesapp.network.datasource

import com.beatrice.moviesapp.network.model.MovieNetworkResult
import com.beatrice.moviesapp.network.util.NetworkResult

interface MoviesDataSource {
    suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult>
}