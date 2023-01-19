package com.beatrice.moviesapp.utils

import com.beatrice.network.moviesDataSource.MoviesDataSource
import com.beatrice.network.model.MovieNetworkResult

class FakeMoviesDataSource : com.beatrice.network.moviesDataSource.MoviesDataSource {
    override suspend fun getPopularMovies(): Result<com.beatrice.network.model.MovieNetworkResult?> {
        return Result.success(movieNetworkResult)
    }
}