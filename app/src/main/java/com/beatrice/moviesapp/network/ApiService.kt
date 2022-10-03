package com.beatrice.moviesapp.network

import com.beatrice.moviesapp.network.model.MovieResult
import retrofit2.http.GET


interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieResult // Change this to a Network result
}