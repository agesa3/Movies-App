package com.beatrice.moviesapp.core.network.datasource

import com.beatrice.moviesapp.core.database.model.MovieEntity
import com.beatrice.moviesapp.core.network.model.MovieNetworkResult
import retrofit2.Response

interface MoviesDataSource {
    suspend fun getPopularMovies(): Result<MovieNetworkResult?>
}