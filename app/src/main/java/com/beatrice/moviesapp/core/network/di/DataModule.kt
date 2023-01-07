package com.beatrice.moviesapp.core.network.di

import com.beatrice.moviesapp.core.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.core.network.datasource.MoviesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun provideMovieDataSource(moviesDataSourceImpl: MoviesDataSourceImpl): MoviesDataSource
}