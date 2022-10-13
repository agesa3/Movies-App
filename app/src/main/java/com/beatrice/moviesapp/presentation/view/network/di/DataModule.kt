package com.beatrice.moviesapp.presentation.view.network.di

import com.beatrice.moviesapp.presentation.view.network.datasource.MoviesDataSource
import com.beatrice.moviesapp.presentation.view.network.datasource.MoviesDataSourceImpl
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