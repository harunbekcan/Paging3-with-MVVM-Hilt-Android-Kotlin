package com.harunbekcan.paging3sampleproject.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.harunbekcan.paging3sampleproject.R
import com.harunbekcan.paging3sampleproject.base.BaseFragment
import com.harunbekcan.paging3sampleproject.databinding.FragmentPopularMovieBinding
import com.harunbekcan.paging3sampleproject.ui.adapter.PopularMoviePagingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularMovieFragment : BaseFragment<FragmentPopularMovieBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_popular_movie
    private lateinit var popularMoviePagingAdapter: PopularMoviePagingAdapter
    private val viewModel: PopularMovieViewModel by viewModels()

    override fun prepareView(savedInstanceState: Bundle?) {
        initAdapter()
        pagingObserve()
        initPagingAdapterLoadStateListener()
    }

    private fun initAdapter(){
        popularMoviePagingAdapter = PopularMoviePagingAdapter()
        binding.popularMoviesRecyclerView.adapter = popularMoviePagingAdapter
    }

    private fun initPagingAdapterLoadStateListener(){
        popularMoviePagingAdapter.addLoadStateListener { combinedLoadStates->
            if (combinedLoadStates.refresh is LoadState.Loading ){
                Log.i("harunbekcan","loading")
            } else {
                Log.i("harunbekcan","notLoading")
            }
        }
    }

    private fun pagingObserve() {
        lifecycleScope.launch {
            viewModel.getPopularMovies().collectLatest { response ->
                popularMoviePagingAdapter.submitData(response)
            }
        }
    }
}