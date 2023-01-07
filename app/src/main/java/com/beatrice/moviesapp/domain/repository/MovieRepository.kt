package com.beatrice.moviesapp.domain.repository

import com.beatrice.moviesapp.core.data.Syncable
import com.beatrice.moviesapp.domain.model.MovieDomainModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository: Syncable {
    fun getPopularMovies(): Flow<List<MovieDomainModel>>
}