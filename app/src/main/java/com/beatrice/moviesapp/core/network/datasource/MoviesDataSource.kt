package com.beatrice.moviesapp.core.network.datasource

import com.beatrice.moviesapp.core.network.model.MovieNetworkResult

interface MoviesDataSource {
    suspend fun getPopularMovies(): Result<MovieNetworkResult?>
}