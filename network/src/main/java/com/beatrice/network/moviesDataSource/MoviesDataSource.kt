package com.beatrice.network.moviesDataSource

import com.beatrice.network.model.MoviesResponse

interface MoviesDataSource {
    suspend fun getPopularMovies(): Result<MoviesResponse?>
}
