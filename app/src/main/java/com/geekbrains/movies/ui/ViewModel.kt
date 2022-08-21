package com.geekbrains.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.movies.data.network.Retrofit
import com.geekbrains.movies.data.repository.RemoteRepositiryImp
import com.geekbrains.movies.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModel (private val repo: Repository = RemoteRepositiryImp(Retrofit().getService())) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    fun getData(): LiveData<AppState> {
        return liveDataToObserve
    }

    fun requestMovie() = requestMovieFromApi()

    private fun requestMovieFromApi() {
        repo.getMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                liveDataToObserve.postValue(AppState.Loading)
            }
            .subscribe({
                liveDataToObserve.postValue(AppState.Success(it))
            },{
                liveDataToObserve.postValue(AppState.Error(Throwable(ERROR_MESSAGE)))
            })
    }

    companion object {
        const val ERROR_MESSAGE = "RxJava Error"
    }
}