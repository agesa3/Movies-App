package com.beatrice.moviesapp.network.model

data class MovieNetworkResult(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)