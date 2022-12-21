package com.beatrice.moviesapp.domain.repository

import com.beatrice.moviesapp.core.data.Syncable
import com.beatrice.moviesapp.core.network.util.NetworkResult
import com.beatrice.moviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository: Syncable {
    fun getPopularMovies(): Flow<NetworkResult<List<Movie>>>
}