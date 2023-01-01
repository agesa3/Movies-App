package com.beatrice.moviesapp.core.repository

import com.beatrice.moviesapp.utils.FakeMovieDao
import com.beatrice.moviesapp.utils.FakeMoviesDataSource
import com.beatrice.moviesapp.utils.FakeSynchronizer
import junit.runner.Version.id
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test


class MovieRepositoryImplTest{
    private val moviesDao = FakeMovieDao()
    private val moviesDataSources = FakeMoviesDataSource()
    private val synchronizer  = FakeSynchronizer()
    val repository = MovieRepositoryImpl(
        movieDao = moviesDao,
        moviesDataSource= moviesDataSources
    )

    @Test
    fun `test movies repository sync local data with remote data`() = runTest{

        repository.syncWith(synchronizer)
        val latestMovies = moviesDao.getMovies()

        // Delete Obsolete movies
        val isDeleted = latestMovies.any { it.id == 123 || it.id  == 129}
        assertThat(isDeleted, `is`(false))

        // update existing movies
        val updateMovie = latestMovies.find { it.id == 127 }
        assertThat(updateMovie != null, `is`(true))
        assertThat(updateMovie!!.voteAverage, `is`(14.5))

        // Save new movies
        val newMovie = latestMovies.find { it.id == 128 }
        assertThat(newMovie != null, `is`(true))
        assertThat(newMovie!!.tag, `is`("NEW"))

        assertThat(latestMovies.size, `is`(3))
    }
}