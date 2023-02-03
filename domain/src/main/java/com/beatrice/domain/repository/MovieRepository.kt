package com.beatrice.domain.repository

import com.beatrie.domain.models.MovieDomainModel
import com.beatrie.domain.util.Syncable
import kotlinx.coroutines.flow.Flow

interface MovieRepository : Syncable {
    fun getPopularMovies(): Flow<List<MovieDomainModel>>
}
