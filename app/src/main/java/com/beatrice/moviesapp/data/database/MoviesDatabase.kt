package com.beatrice.moviesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beatrice.moviesapp.data.database.dao.MovieDao
import com.beatrice.moviesapp.data.database.model.MovieEntity

@Database(
    entities = [
        MovieEntity::class
    ], version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}