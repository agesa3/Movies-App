package com.beatrice.network.di

import com.beatrice.network.moviesDataSource.MoviesDataSource
import com.beatrice.network.moviesDataSource.MoviesDataSourceImpl
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
