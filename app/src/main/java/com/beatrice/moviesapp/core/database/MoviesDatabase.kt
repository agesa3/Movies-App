package com.beatrice.moviesapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beatrice.moviesapp.core.database.dao.ChangeListVersionDao
import com.beatrice.moviesapp.core.database.dao.MovieDao
import com.beatrice.moviesapp.core.database.model.ChangeListVersionEntity
import com.beatrice.moviesapp.core.database.model.MovieEntity

@Database(
    entities = [
        ChangeListVersionEntity::class,
        MovieEntity::class
    ], version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun changeListVersionDao(): ChangeListVersionDao
}