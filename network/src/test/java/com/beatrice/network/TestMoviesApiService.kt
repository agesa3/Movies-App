package com.beatrice.network

import com.beatrice.network.model.MoviesResponse
import com.beatrice.network.utils.moviesResponse
import retrofit2.Response

class TestMoviesApiService: MoviesApiService {
    override suspend fun getPopularMovies(): Response<MoviesResponse> =
        Response.success(moviesResponse)

}