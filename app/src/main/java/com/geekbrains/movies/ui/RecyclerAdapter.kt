package com.geekbrains.movies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.movies.databinding.RecyclerItemBinding
import com.geekbrains.movies.domain.Movie

class RecyclerAdapter :
    RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>() {

    private var filmData: List<Movie> = listOf()
    private var onItemViewClickListener: ScreenFragment.OnItemViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmData[position])
    }

    override fun getItemCount(): Int {
        return filmData.size
    }

    inner class MainViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                title.text = movie.title
                root.setOnClickListener {
                    onItemViewClickListener?.onItemViewClick(movie)
                }
            }
        }
    }

    fun setOnItemViewClickListener(onItemViewClickListener: ScreenFragment.OnItemViewClickListener) {
        this.onItemViewClickListener = onItemViewClickListener
    }

    fun removeOnItemViewClickListener() {
        onItemViewClickListener = null
    }
    fun setData(data: List<Movie>) {
        filmData = data
        notifyDataSetChanged()
    }
}