package com.harunbekcan.paging3sampleproject.data.api

import com.harunbekcan.paging3sampleproject.base.BasePagingResponse
import com.harunbekcan.paging3sampleproject.data.response.PopularMovieResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): BasePagingResponse<PopularMovieResponseItem>
}