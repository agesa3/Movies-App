package com.beatrice.network

import com.beatrice.network.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET


interface MoviesApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MoviesResponse>
}

