package com.geekbrains.movies.data.repository

import com.geekbrains.movies.domain.Movie
import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getMovie(): Single<List<Movie>>
}