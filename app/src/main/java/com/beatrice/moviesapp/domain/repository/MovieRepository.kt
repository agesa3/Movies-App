package com.beatrice.moviesapp.domain.repository

import com.beatrice.moviesapp.data.network.util.NetworkResult
import com.beatrice.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<NetworkResult<List<Movie>>>
}