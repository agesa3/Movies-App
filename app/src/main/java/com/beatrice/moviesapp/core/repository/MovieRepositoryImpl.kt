package com.beatrice.moviesapp.core.repository

import com.beatrice.moviesapp.core.data.Synchronizer
import com.beatrice.moviesapp.core.data.changeListSync
import com.beatrice.moviesapp.core.data.util.MovieEnums
import com.beatrice.moviesapp.core.database.dao.MovieDao
import com.beatrice.moviesapp.core.database.model.MovieEntity
import com.beatrice.moviesapp.core.database.model.toMoviesList
import com.beatrice.moviesapp.core.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.core.network.model.toMovieEntityList
import com.beatrice.moviesapp.domain.model.Movie
import com.beatrice.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Locale.filter
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val moviesDataSource: MoviesDataSource
) : MovieRepository {
    override fun getPopularMovies(): Flow<List<Movie>> = flow {
        val movies = movieDao.getMovies()
        val moviesList = movies.toMoviesList()
        emit(moviesList)
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        return synchronizer.changeListSync(

            itemsFetcher = {
                moviesDataSource.getPopularMovies()
            },
            changeListFetcher = { movieResult ->
                val fetchedMovies = movieResult?.toMovieEntityList()?.asSequence()
                val fetchedMoviesIds = fetchedMovies?.map { it.id }
                val oldMovies = movieDao.getMovies()
                val oldMoviesIds = oldMovies.map { it.id }

                val newMovies = fetchedMovies
                    ?.filter { it.id !in oldMoviesIds }
                    ?.map {
                        it.tag = MovieEnums.NEW.name
                    }?.toList()
                val moviesToUpdate = fetchedMovies?.filter {
                    it.id in oldMoviesIds
                }?.toList()

                val moviesToDelete =
                    oldMovies.filter { (fetchedMoviesIds != null) && (it.id !in fetchedMoviesIds) }

                val changeListCollection = mapOf(
                    "new" to newMovies,
                    "toUpdate" to moviesToUpdate,
                    "toDelete" to moviesToDelete
                )
                changeListCollection
            },
            modelUpdater = { changeList ->
                // Save new movies
                val newMovies = changeList["new"]
                newMovies?.let {
                    val movies = it as List<MovieEntity>
                    movieDao.insertMovies(movies)
                }

                val moviesToUpdate = changeList["toUpdate"]
                moviesToUpdate?.let {
                    val movies = it as List<MovieEntity>
                    movieDao.updateMovies(movies)
                }

                val moviesToDelete = changeList["toDelete"]
                moviesToDelete?.let {alist ->
                    val movies = alist as List<MovieEntity>
                    val moviesIds = movies.map { it.id }
                    movieDao.deleteMovies(moviesIds)
                }

            },
        )
    }
}