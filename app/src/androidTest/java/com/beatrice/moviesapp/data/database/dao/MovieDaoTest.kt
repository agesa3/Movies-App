package com.beatrice.moviesapp.data.database.dao

import androidx.room.Room
import com.beatrice.moviesapp.data.database.MoviesDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import androidx.test.platform.app.InstrumentationRegistry
import com.beatrice.moviesapp.resources.fakeMovieList
import org.junit.Assert
import org.junit.Test

class MovieDaoTest {

    private lateinit var database: MoviesDatabase
    private lateinit var movieDao: MovieDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, MoviesDatabase::class.java)
            .allowMainThreadQueries().build()
        movieDao = database.movieDao()
    }

    @After
    fun tearDown() {
        runBlocking {
            movieDao.deleteMovies()
            database.close()
        }
    }

    @Test
    fun insertMovies() {
        runBlocking {
            val moviesTestFake = fakeMovieList

            val reposTestListUtil = listOf(moviesTestFake)
            movieDao.insertMovies(reposTestListUtil)

            val result = movieDao.getMovies()
            Assert.assertEquals(reposTestListUtil, result)
        }
    }

    @Test
    fun deleteMovies() {
        runBlocking {
            movieDao.insertMovies(listOf(fakeMovieList))
            movieDao.deleteMovies()
            val usersFollowers = movieDao.getMovies()
            assert(usersFollowers.isEmpty())
        }
    }

}