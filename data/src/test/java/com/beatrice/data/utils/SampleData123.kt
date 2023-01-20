package com.beatrice.data.utils

import com.beatrice.database.model.MovieEntity
import com.beatrice.network.model.MoviesResponse


val movieNetworkResult: MoviesResponse
    get() = MoviesResponse(
        page = 1,
        total_pages = 10,
        total_results = 200,
        results = moviesResultRemote,
    )
val moviesResultRemote = listOf(
    com.beatrice.network.model.Movie(
        id = 127,
        title = "Prison",
        original_title = "The Prison",
        original_language = "en",
        release_date = "December",
        vote_count = 12367,
        vote_average = 14.5,
        popularity = 129.1,
        poster_path = "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F01%2Fprison-break.jpg&q=60",
        backdrop_path = "https://m.media-amazon.com/images/M/MV5BNDFmMzM3NzctZGE0MC00NGVmLTljZmUtYTNiZjA2ZTE4NjQwXkEyXkFqcGdeQXVyNzg3MDUyMzc@._V1_.jpg",
        overview = "Great series",
        adult = false,
        genre_ids = emptyList(),
        video = true
    ),
    com.beatrice.network.model.Movie(
        id = 128,
        title = "Break prison",
        original_title = "The Prison Break",
        original_language = "en",
        release_date = "December",
        vote_count = 12367,
        vote_average = 12.5,
        popularity = 123.1,
        poster_path = "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F01%2Fprison-break.jpg&q=60",
        backdrop_path = "https://m.media-amazon.com/images/M/MV5BNDFmMzM3NzctZGE0MC00NGVmLTljZmUtYTNiZjA2ZTE4NjQwXkEyXkFqcGdeQXVyNzg3MDUyMzc@._V1_.jpg",
        overview = "Great series",
        adult = false,
        genre_ids = emptyList(),
        video = true
    ),
)
val moviesListLocal = mutableListOf(
    com.beatrice.database.model.MovieEntity(
        id = 123,
        title = "Prison Break",
        originalTitle = "The Prison Break",
        language = "en",
        releaseDate = "December",
        voteCount = 12367,
        voteAverage = 12.5,
        popularity = 123.1,
        posterPath = "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F01%2Fprison-break.jpg&q=60",
        backdropPath = "https://m.media-amazon.com/images/M/MV5BNDFmMzM3NzctZGE0MC00NGVmLTljZmUtYTNiZjA2ZTE4NjQwXkEyXkFqcGdeQXVyNzg3MDUyMzc@._V1_.jpg",
        overview = "Great series",
        tag = null
    ),
    com.beatrice.database.model.MovieEntity(
        id = 127,
        title = "Prison",
        originalTitle = "The Prison",
        language = "en",
        releaseDate = "December",
        voteCount = 12367,
        voteAverage = 12.5,
        popularity = 123.1,
        posterPath = "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F01%2Fprison-break.jpg&q=60",
        backdropPath = "https://m.media-amazon.com/images/M/MV5BNDFmMzM3NzctZGE0MC00NGVmLTljZmUtYTNiZjA2ZTE4NjQwXkEyXkFqcGdeQXVyNzg3MDUyMzc@._V1_.jpg",
        overview = "Great series",
        tag = null
    ),
    com.beatrice.database.model.MovieEntity(
        id = 129,
        title = "Break",
        originalTitle = "The Prison Break",
        language = "en",
        releaseDate = "December",
        voteCount = 12367,
        voteAverage = 12.5,
        popularity = 123.1,
        posterPath = "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F6%2F2016%2F01%2Fprison-break.jpg&q=60",
        backdropPath = "https://m.media-amazon.com/images/M/MV5BNDFmMzM3NzctZGE0MC00NGVmLTljZmUtYTNiZjA2ZTE4NjQwXkEyXkFqcGdeQXVyNzg3MDUyMzc@._V1_.jpg",
        overview = "Great series",
        tag = "NEW"
    )
)