package com.beatrice.moviesapp.utils

import com.beatrice.moviesapp.core.database.dao.MovieDao
import com.beatrice.moviesapp.core.database.model.MovieEntity
import junit.runner.Version.id

class FakeMovieDao : MovieDao {
    override suspend fun getMovies(): List<MovieEntity> = moviesListLocal

    override suspend fun insertMovies(list: List<MovieEntity>) {
        moviesListLocal.addAll(list)
    }

    override suspend fun updateMovies(moviesList: List<MovieEntity>) {
        moviesList.forEach { anUpdate ->
            moviesListLocal.filter{ it.id == anUpdate.id }.forEach{
                 it.voteAverage = anUpdate.voteAverage
            }
        }
    }

    override suspend fun deleteMovies(idList: List<Int>) {
        val oldMovies = moviesListLocal.filter { it.id in idList }
        moviesListLocal.removeAll(oldMovies)
    }
}