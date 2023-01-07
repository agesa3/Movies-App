package com.beatrice.moviesapp.core.di

import com.beatrice.moviesapp.domain.repository.MovieRepository
import com.beatrice.moviesapp.core.repository.MovieRepositoryImpl
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