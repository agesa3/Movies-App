package com.beatrice.moviesapp.presentation.view.network

import com.beatrice.moviesapp.presentation.view.network.model.MovieNetworkResult
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieNetworkResult>
}

