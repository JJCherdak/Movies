package com.geekbrains.movies.data.repository


import com.geekbrains.movies.data.network.ApiService
import com.geekbrains.movies.domain.Converter
import com.geekbrains.movies.domain.Movie
import io.reactivex.rxjava3.core.Single

class RemoteRepositiryImp(private val repo: ApiService) : Repository {
    override fun getMovie(): Single<List<Movie>> {
        return repo.getMovies().map {
            Converter.convertResponseToMovies(it.results)
        }
    }
}