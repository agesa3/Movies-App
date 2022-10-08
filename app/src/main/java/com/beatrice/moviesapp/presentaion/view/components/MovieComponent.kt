package com.beatrice.moviesapp.presentaion.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.beatrice.moviesapp.R
import com.beatrice.moviesapp.data.model.Movie

@Composable
fun MovieComponent(
    movie: Movie
) {
    /**
     * TODO: Alternating colors background and the border
     */
    Card(
        modifier= Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp)


    ) {
        Row(
            modifier = Modifier.padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data("URL").build(),
                placeholder = painterResource(id = R.drawable.ic_baseline_movie_24),
                contentDescription = stringResource(R.string.movie_poster),
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Text(
                    text = movie.title,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )
                )
                Text(
                    text = movie.releaseDate,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    text = movie.language, style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
                Text(text = movie.overview, style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                    color = Color.Gray
                ))
            }
        }


    }
}

@Preview
@Composable
fun MovieComponentPreview() {
    Surface(color = Color.White) {
        MovieComponent(
            movie = Movie(
                title = "Abc",
                originalTitle = "ABC",
                voteAverage = 0.0,
                posterPath = "ABC",
                backdropPath = "ABC",
                releaseDate = "ABC",
                language = "en",
                popularity = 0.0,
                voteCount = 0,
                overview = "asdfasdf"
            )
        )

    }
}