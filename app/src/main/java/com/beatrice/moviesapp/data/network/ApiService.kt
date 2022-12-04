package com.beatrice.moviesapp.data.network

import com.beatrice.moviesapp.data.network.model.MovieNetworkResult
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieNetworkResult>
}

