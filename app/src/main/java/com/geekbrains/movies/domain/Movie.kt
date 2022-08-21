package com.geekbrains.movies.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val image: String,
    val title: String,
    val rating: String,
    val year: String,
    val description: String,
    val genres: List<String>,
    val actors: List<String>
    ) : Parcelable