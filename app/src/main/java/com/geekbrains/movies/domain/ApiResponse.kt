package com.geekbrains.movies.domain

data class ApiResponse(
    val results: List<MovieResponse>
)

data class MovieResponse(
    val _id: String,
    val image: String,
    val title: String,
    val rating: String,
    val release: String,
    val description: String,
    val genres: List<GenreResponse>,
    val actors: List<ActorResponse>
)

data class GenreResponse(
    val name: String
)

data class ActorResponse(
    val name: String,
)
