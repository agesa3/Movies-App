package com.beatrice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beatrice.database.dao.MovieDao
import com.beatrice.database.model.MovieEntity

@Database(
    entities = [
        MovieEntity::class
    ],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
