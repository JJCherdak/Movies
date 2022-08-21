package com.geekbrains.movies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.movies.databinding.CastRecyclerItemBinding

class InfoRecyclerAdapter:
    RecyclerView.Adapter<InfoRecyclerAdapter.MainViewHolder>() {

    private var movieData: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = CastRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    inner class MainViewHolder(private val binding: CastRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: String) {
            binding.apply {
                title.text = person
            }
        }
    }

    fun setData(data: List<String>) {
        movieData = data
        notifyDataSetChanged()
    }
}