package com.harunbekcan.paging3sampleproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.paging3sampleproject.data.response.PopularMovieResponseItem
import com.harunbekcan.paging3sampleproject.databinding.ItemPopularMovieLayoutBinding
import com.harunbekcan.paging3sampleproject.utils.executeWithAction
import javax.inject.Inject

class PopularMoviePagingAdapter
@Inject
constructor() :
    PagingDataAdapter<PopularMovieResponseItem, PopularMoviePagingAdapter.PopularMovieViewHolder>(
        DiffUtils
    ) {

    class PopularMovieViewHolder(private val binding: ItemPopularMovieLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popularMovieResponseItem: PopularMovieResponseItem) {
            binding.executeWithAction {
                this.item = popularMovieResponseItem
            }
        }
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val popularMovieItem = getItem(position)
        if (popularMovieItem != null) {
            holder.bind(popularMovieItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder(
            ItemPopularMovieLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    object DiffUtils : DiffUtil.ItemCallback<PopularMovieResponseItem>() {
        override fun areItemsTheSame(
            oldItem: PopularMovieResponseItem,
            newItem: PopularMovieResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PopularMovieResponseItem,
            newItem: PopularMovieResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }
}