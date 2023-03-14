package com.harunbekcan.paging3sampleproject.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.harunbekcan.paging3sampleproject.data.api.ServiceInterface
import com.harunbekcan.paging3sampleproject.data.response.PopularMovieResponseItem
import com.harunbekcan.paging3sampleproject.utils.Constant

class PopularMoviePagingSource constructor(
    private val serviceInterface: ServiceInterface
) : PagingSource<Int, PopularMovieResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PopularMovieResponseItem> {

        return try {
            val pageNumber = params.key ?: 1
            val response = serviceInterface.getPopularMovies(Constant.API_KEY,pageNumber)

            LoadResult.Page(
                data = response.results,
                prevKey = if (pageNumber > 1) pageNumber - 1 else null,
                nextKey = if (pageNumber < response.total_pages) pageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PopularMovieResponseItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}