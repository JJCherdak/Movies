package com.geekbrains.movies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.geekbrains.movies.R
import com.geekbrains.movies.data.repository.FakeRepository
import com.geekbrains.movies.databinding.InfoScreenLayoutBinding
import com.geekbrains.movies.domain.Movie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class InfoFragment: Fragment() {

    private var _binding: InfoScreenLayoutBinding? = null
    private val binding get() = _binding!!
    private val adapter = InfoRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InfoScreenLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainFragmentRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mainFragmentRecyclerView.adapter = adapter

        val movie = arguments?.getParcelable<Movie>(BUNDLE_EXTRA)!!
        with (binding) {
        FakeRepository().getMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapter.setData(it[0].actors) },{})


                title.text = movie.title
                score.text = movie.rating
                description.text = movie.description
                genre.text = movie.genres.toString().removePrefix("[").removeSuffix("]")
                date.text = movie.year
                Glide.with(binding.poster.context)
                    .load(movie.image)
                    .error(R.drawable.background)
                    .placeholder(R.drawable.poster)
                    .into(this.poster)
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "MOVIE_ID"

        fun newInstance(bundle: Bundle): InfoFragment {
            val fragment = InfoFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}