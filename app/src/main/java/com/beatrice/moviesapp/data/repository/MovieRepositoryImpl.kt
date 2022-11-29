package com.beatrice.moviesapp.data.repository

import com.beatrice.moviesapp.data.database.dao.MovieDao
import com.beatrice.moviesapp.data.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.data.network.util.NetworkResult
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
    override  fun getPopularMovies(): Flow<NetworkResult<List<Movie>>> = flow{
        val networkResponse = moviesDataSource.getPopularMovies()
        val result =  when(networkResponse){
            is NetworkResult.Success -> {
              val movies =  networkResponse.data.toMoviesList()
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
}