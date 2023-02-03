package com.beatrice.data.utils

import com.beatrice.database.model.MovieEntity
import kotlinx.coroutines.flow.flowOf

class FakeMovieDao : com.beatrice.database.dao.MovieDao {
    override fun getMovies() = flowOf(moviesListLocal)

    override suspend fun insertMovies(list: List<MovieEntity>) {
        moviesListLocal.addAll(list)
    }

    override suspend fun updateMovies(moviesList: List<MovieEntity>) {
        moviesList.forEach { anUpdate ->
            moviesListLocal.filter { it.id == anUpdate.id }.forEach {
                it.voteAverage = anUpdate.voteAverage
            }
        }
    }

    override suspend fun deleteMovies(idList: List<Int>) {
        val oldMovies = moviesListLocal.filter { it.id in idList }
        moviesListLocal.removeAll(oldMovies)
    }
}
