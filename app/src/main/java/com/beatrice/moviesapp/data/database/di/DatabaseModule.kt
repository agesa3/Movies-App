package com.beatrice.moviesapp.data.database.di

import android.content.Context
import androidx.room.Room
import com.beatrice.moviesapp.data.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext applicationContext: Context) =
            Room.databaseBuilder(applicationContext, MoviesDatabase::class.java, "movies").build()
    @Provides
    fun provideMovieDao(moviesDatabase: MoviesDatabase) = moviesDatabase.movieDao()

}