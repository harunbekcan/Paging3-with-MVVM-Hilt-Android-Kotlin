package com.harunbekcan.paging3sampleproject.ui.fragment

import android.os.Bundle
import com.harunbekcan.paging3sampleproject.R
import com.harunbekcan.paging3sampleproject.base.BaseFragment
import com.harunbekcan.paging3sampleproject.databinding.FragmentPopularMovieBinding

class PopularMovieFragment : BaseFragment<FragmentPopularMovieBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_popular_movie

    override fun prepareView(savedInstanceState: Bundle?) {

    }
}