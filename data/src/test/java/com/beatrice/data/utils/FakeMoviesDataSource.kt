package com.beatrice.data.utils

import com.beatrice.network.model.MoviesResponse

class FakeMoviesDataSource : com.beatrice.network.moviesDataSource.MoviesDataSource {
    override suspend fun getPopularMovies(): Result<MoviesResponse?> {
        return Result.success(movieNetworkResult)
    }
}
