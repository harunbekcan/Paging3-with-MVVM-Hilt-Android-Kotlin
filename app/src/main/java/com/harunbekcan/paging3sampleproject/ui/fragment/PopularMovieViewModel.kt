package com.harunbekcan.paging3sampleproject.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.harunbekcan.paging3sampleproject.data.api.ServiceInterface
import com.harunbekcan.paging3sampleproject.data.pagingdatasource.PopularMoviePagingSource
import com.harunbekcan.paging3sampleproject.data.response.PopularMovieResponseItem
import com.harunbekcan.paging3sampleproject.utils.Constant.NETWORK_PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(private val serviceInterface: ServiceInterface) : ViewModel() {

    fun getPopularMovies(): Flow<PagingData<PopularMovieResponseItem>> {
        return Pager(config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { PopularMoviePagingSource(serviceInterface) }
        ).flow
    }
}