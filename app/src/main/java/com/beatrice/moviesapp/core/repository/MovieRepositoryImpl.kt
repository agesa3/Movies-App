package com.beatrice.moviesapp.core.repository

import com.beatrice.moviesapp.core.data.Synchronizer
import com.beatrice.moviesapp.core.data.changeListSync
import com.beatrice.moviesapp.core.database.dao.MovieDao
import com.beatrice.moviesapp.core.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.core.network.util.NetworkResult
import com.beatrice.moviesapp.domain.model.Movie
import com.beatrice.moviesapp.domain.model.toMoviesList
import com.beatrice.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val moviesDataSource: MoviesDataSource
) : MovieRepository {
    override fun getPopularMovies(): Flow<NetworkResult<List<Movie>>> = flow {
        // TODO: Get movies from local db
        val networkResponse = moviesDataSource.getPopularMovies()
        val result = when (networkResponse) {
            is NetworkResult.Success -> {
                val movies = networkResponse.data.toMoviesList()
                NetworkResult.Success(data = movies)
            }
            is NetworkResult.Error -> {
                NetworkResult.Error(code = networkResponse.code, message = networkResponse.message)
            }
            is NetworkResult.Exception -> {
                NetworkResult.Exception(e = networkResponse.e)
            }
        }
        emit(result)
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        synchronizer.changeListSync()
    }
}