package com.geekbrains.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geekbrains.movies.data.repository.FakeRepository
import androidx.lifecycle.ViewModel

open class MainViewModel (private val repo: FakeRepository = FakeRepository()) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    fun getData(): LiveData<AppState> {
        return liveDataToObserve
    }

    fun requestMovie() = requestMovieFromApi()

    private fun requestMovieFromApi() {
        liveDataToObserve.postValue(AppState.Success(repo.getList()))
    }
}