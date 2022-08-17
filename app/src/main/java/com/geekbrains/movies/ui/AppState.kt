package com.geekbrains.movies.ui

import com.geekbrains.movies.domain.Movie

sealed class AppState {
    data class Success(val dataList: List<Movie>) : AppState()
    class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}