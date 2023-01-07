package com.beatrice.moviesapp.utils

import com.beatrice.moviesapp.core.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.core.network.model.MovieNetworkResult

class FakeMoviesDataSource : MoviesDataSource {
    override suspend fun getPopularMovies(): Result<MovieNetworkResult?> {
        return Result.success(movieNetworkResult)
    }
}