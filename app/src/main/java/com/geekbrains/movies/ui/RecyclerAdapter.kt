package com.geekbrains.movies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geekbrains.movies.R
import com.geekbrains.movies.databinding.RecyclerItemBinding
import com.geekbrains.movies.domain.Movie

class RecyclerAdapter :
    RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>() {

    private var MovieData: List<Movie> = listOf()
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
        holder.bind(MovieData[position])
    }

    override fun getItemCount(): Int {
        return MovieData.size
    }

    inner class MainViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                title.text = movie.title
                date.text = movie.year
                Glide.with(binding.poster.context)
                    .load(movie.image)
                    .error(R.drawable.background)
                    .placeholder(R.drawable.poster)
                    .into(this.poster)

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
        MovieData = data
        notifyDataSetChanged()
    }
}