package com.beatrice.moviesapp.presentaion.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beatrice.moviesapp.data.model.Movie

@Composable
fun MoviesListComponent(movies: List<Movie>, resultType: String = "Popular Movies") {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(top = 20.dp, bottom = 40.dp, start = 20.dp, end = 20.dp)
    ) {
        item {
            Text(
                text = resultType,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray,
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Serif
                ),
                textAlign = TextAlign.Center
            )
        }
        items(movies) { movie ->
            MovieComponent(movie = movie)
        }
    }
}

@Preview
@Composable
fun MoviesListComponentPreview(){
    Surface(color =  Color.White) {
        MoviesListComponent(movies = movieList)
    }
}

val movieList = listOf(
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
    Movie(
        title = "Abc",
        originalTitle = "ABC",
        voteAverage = 0.0,
        posterPath = "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg",
        backdropPath = "ABC",
        releaseDate = "2022.10.3",
        language = "en",
        popularity = 0.0,
        voteCount = 0,
        overview = "The quick brown fox jumped over a lazy dog." +
                " The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog. " +
                "The quick brown fox jumped over a lazy dog."
    ),
)