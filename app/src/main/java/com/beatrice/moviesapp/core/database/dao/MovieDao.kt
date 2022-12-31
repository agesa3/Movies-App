package com.beatrice.moviesapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.beatrice.moviesapp.core.database.model.MovieEntity
import com.beatrice.moviesapp.domain.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    suspend fun getMovies():List<MovieEntity>

    @Insert
    suspend fun insertMovies(list: List<MovieEntity>)

    @Update
    suspend fun updateMovies(moviesList: List<MovieEntity>)

    @Query("DELETE FROM movie_table WHERE id in (:idList)")
    suspend fun deleteMovies(idList: List<Int>)
}