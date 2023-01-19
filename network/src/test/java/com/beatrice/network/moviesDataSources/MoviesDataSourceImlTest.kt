package com.beatrice.network.moviesDataSources

import com.beatrice.network.TestMoviesApiService
import com.beatrice.network.moviesDataSource.MoviesDataSourceImpl
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test

class MoviesDataSourceImlTest {
    private val apiService = TestMoviesApiService()
    private val datasource = MoviesDataSourceImpl(apiService)

    @Test
    fun `test fetching movies return success`() = runTest{

     val result = datasource.getPopularMovies()
        assertTrue(result.isSuccess)
        val data = result.getOrNull()
        assertTrue(data != null)
        assertEquals(data?.page, 1)
        assertEquals(data?.results?.size, 2)
        assertEquals(data?.results?.get(0)?.original_title, "The Prison")

    }


}