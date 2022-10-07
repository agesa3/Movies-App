package com.beatrice.moviesapp.network

import com.beatrice.moviesapp.network.model.MovieNetworkResult
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieNetworkResult>
}

