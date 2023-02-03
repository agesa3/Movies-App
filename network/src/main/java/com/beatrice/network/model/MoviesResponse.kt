package com.beatrice.network.model

data class MoviesResponse(
    val page: Int?,
    val results: List<Movie>?,
    val total_pages: Int?,
    val total_results: Int?
)
