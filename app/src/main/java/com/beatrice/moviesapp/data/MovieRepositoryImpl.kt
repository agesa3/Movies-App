package com.beatrice.moviesapp.data

import android.util.Log
import com.beatrice.moviesapp.database.dao.MovieDao
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao
): MovieRepository {
    override  fun getMovies() {
        Log.d("TEEEEST", "Working okay")
    }
}