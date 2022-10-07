package com.beatrice.moviesapp.data

import com.beatrice.moviesapp.network.util.NetworkResult
import com.beatrice.moviesapp.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<NetworkResult<List<Movie>>>
}