package com.geekbrains.movies.data.repository

import com.geekbrains.movies.domain.Movie
import io.reactivex.rxjava3.core.Single

class FakeRepository: Repository {
    override fun getMovie(): Single<List<Movie>> = Single.just(listOf(

        Movie("w3r", "hkgfuty", "Title 1", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma", "Jinx", "Vi", "Kim")),
        Movie("w3r", "hkgfuty", "Title 2", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 3", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 4", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 5", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 6", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 7", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 8", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Movie("w3r", "hkgfuty", "Title 9", "7.3/10", "2017", "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
    ))
}