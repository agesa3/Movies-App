package com.beatrice.moviesapp.di

import com.beatrice.moviesapp.data.MovieRepository
import com.beatrice.moviesapp.data.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun provideMoviesRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}