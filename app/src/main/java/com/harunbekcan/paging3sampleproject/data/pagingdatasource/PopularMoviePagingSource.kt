package com.harunbekcan.paging3sampleproject.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.harunbekcan.paging3sampleproject.data.api.ServiceInterface
import com.harunbekcan.paging3sampleproject.data.response.PopularMovieResponseItem
import com.harunbekcan.paging3sampleproject.utils.Constant

class PopularMoviePagingSource constructor(
    private val serviceInterface: ServiceInterface
) : PagingSource<Int, PopularMovieResponseItem>() {

    override fun getRefreshKey(state: PagingState<Int, PopularMovieResponseItem>): Int {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PopularMovieResponseItem> {
        var pageIndex = 1
        if (params.key != null) {
            pageIndex = params.key!!
        }
        val response = serviceInterface.getPopularMovies(Constant.API_KEY, pageIndex)

        return if (response.results.isNotEmpty()) {
            pageIndex++
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = pageIndex
            )
        } else {
            LoadResult.Page(
                data = arrayListOf(),
                prevKey = null,
                nextKey = null
            )
        }
    }
}