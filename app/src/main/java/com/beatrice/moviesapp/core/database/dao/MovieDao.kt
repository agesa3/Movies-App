package com.beatrice.moviesapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beatrice.moviesapp.core.database.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    suspend fun getMovies():List<MovieEntity>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun insertMovies(list: List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteMovies()
}