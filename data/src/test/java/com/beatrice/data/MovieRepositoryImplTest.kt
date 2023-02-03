package com.beatrice.data

import com.beatrice.data.repository.MovieRepositoryImpl
import com.beatrice.data.utils.FakeMovieDao
import com.beatrice.data.utils.FakeMoviesDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MovieRepositoryImplTest {
    private val moviesDao = FakeMovieDao()
    private val moviesDataSources = FakeMoviesDataSource()
    private val repository = MovieRepositoryImpl(
        movieDao = moviesDao,
        moviesDataSource = moviesDataSources
    )

    @Test
    fun `test movies repository sync local data with remote data`() = runTest {

        repository.sync()
        val latestMovies = moviesDao.getMovies().first()

        // Delete Obsolete movies
        val isDeleted = latestMovies.any { it.id == 123 || it.id == 129 }
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
