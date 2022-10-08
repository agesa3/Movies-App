package com.beatrice.moviesapp.presentaion.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beatrice.moviesapp.data.model.Movie

@Composable
fun MoviesListComponent(movies: List<Movie>){
    LazyColumn(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(movies){ movie ->
            MovieComponent(movie = movie)
        }
    }

}