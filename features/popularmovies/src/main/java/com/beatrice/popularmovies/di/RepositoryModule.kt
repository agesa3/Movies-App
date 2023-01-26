package com.beatrice.popularmovies.di

import com.beatrice.data.repository.MovieRepositoryImpl
import com.beatrice.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun provideMoviesRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}