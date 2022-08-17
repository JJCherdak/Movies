package com.geekbrains.movies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.movies.databinding.InfoScreenLayoutBinding
import com.geekbrains.movies.domain.Movie

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
        arguments?.getParcelable<Movie>(BUNDLE_EXTRA)?.let { movie ->
            adapter.setData(movie.actors)
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