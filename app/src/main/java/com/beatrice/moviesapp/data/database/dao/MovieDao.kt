package com.beatrice.moviesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.beatrice.moviesapp.data.database.model.MovieEntity
import com.beatrice.moviesapp.domain.model.Movie

@Dao
interface MovieDao : BaseDao<MovieEntity>{
    @Query("SELECT * FROM movie_table")
    suspend fun getMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(list: List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteMovies()
}