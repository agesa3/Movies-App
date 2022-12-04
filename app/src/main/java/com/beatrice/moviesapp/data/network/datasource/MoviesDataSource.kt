package com.beatrice.moviesapp.data.network.datasource

import com.beatrice.moviesapp.data.network.model.MovieNetworkResult
import com.beatrice.moviesapp.data.network.util.NetworkResult

interface MoviesDataSource {
    suspend fun getPopularMovies(): NetworkResult<MovieNetworkResult>
}