package com.harunbekcan.paging3sampleproject.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.paging3sampleproject.data.response.PopularMovieResponseItem
import com.harunbekcan.paging3sampleproject.databinding.ItemPopularMovieLayoutBinding
import com.harunbekcan.paging3sampleproject.utils.executeWithAction

class PopularMovieViewHolder(private val binding: ItemPopularMovieLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(popularMovieResponseItem: PopularMovieResponseItem) {
        binding.executeWithAction {
            this.item = popularMovieResponseItem
        }
    }
}