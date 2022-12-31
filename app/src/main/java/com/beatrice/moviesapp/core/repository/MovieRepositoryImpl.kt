package com.beatrice.moviesapp.core.repository

import com.beatrice.moviesapp.core.data.Synchronizer
import com.beatrice.moviesapp.core.data.changeListSync
import com.beatrice.moviesapp.core.database.dao.ChangeListVersionDao
import com.beatrice.moviesapp.core.database.dao.MovieDao
import com.beatrice.moviesapp.core.database.model.toMoviesList
import com.beatrice.moviesapp.core.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.core.network.model.toMovieEntityList
import com.beatrice.moviesapp.core.network.util.NetworkResult
import com.beatrice.moviesapp.domain.model.Movie
import com.beatrice.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val changeListVersionDao: ChangeListVersionDao,
    private val moviesDataSource: MoviesDataSource
) : MovieRepository {
    override fun getPopularMovies(): Flow<List<Movie>> = flow {
        val movies = movieDao.getMovies()
        val moviesList = movies.toMoviesList()
        emit(moviesList)
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        return synchronizer.changeListSync(
            versionReader = {
                changeListVersionDao.getChangeListVersion().movieListVersion
            },
            itemsFetcher = {
                moviesDataSource.getPopularMovies()
            },
            modelDeleter = { result ->
                val fetchedMovies = result.getOrNull()?.toMovieEntityList()

            },
            modelUpdater = { result ->
                val fetchedMovies = result.getOrNull()?.toMovieEntityList()
                val fetchedMoviesIds = fetchedMovies?.map { it.id }
                val oldMovies = movieDao.getMovies()
                val oldMoviesIds = oldMovies.map { it.id }

                // FIXME:https://betterprogramming.pub/upserting-in-room-8207a100db53
                // Save new movies
                val newMovies = fetchedMovies?.filter { it.id !in oldMoviesIds }
                newMovies?.let { new ->
                    movieDao.insertMovies(new)
                }

                // Update existing movies
                val moviesToUpdate = fetchedMovies?.filter {
                    it.id in oldMoviesIds
                }
                moviesToUpdate?.let {
                    movieDao.updateMovies(it)
                }

                // Delete obsolete movies
                fetchedMoviesIds?.let { ids ->
                    val idsToDelete = oldMovies.filter { it.id !in ids }.map { it.id }
                    movieDao.deleteMovies(idsToDelete)
                }

            },
            versionUpdater = {},
        )
    }
}