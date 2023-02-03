package com.beatrice.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.beatrice.database.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table")
    fun getMovies(): Flow<List<MovieEntity>>

    @Insert
    suspend fun insertMovies(list: List<MovieEntity>)

    @Update
    suspend fun updateMovies(moviesList: List<MovieEntity>)

    @Query("DELETE FROM movie_table WHERE id in (:idList)")
    suspend fun deleteMovies(idList: List<Int>)
}
