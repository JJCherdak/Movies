package com.geekbrains.movies.domain

object Converter {

    fun convertResponseToMovies(resp: List<MovieResponse>) : List<Movie> = resp.map { convertResponseToMovie(it) }

    private fun convertResponseToMovie(resp: MovieResponse) : Movie = Movie(
        resp._id,
        resp.image,
        resp.title,
        resp.rating,
        resp.release,
        resp.description,
        convertGenres(resp.genres),
        convertActors(resp.actors)
    )

    private fun convertGenres(genres: List<GenreResponse>) : List<String> = genres.map { it.name }

    private fun convertActors(actors: List<ActorResponse>) : List<String> = actors.map { it.name }
}