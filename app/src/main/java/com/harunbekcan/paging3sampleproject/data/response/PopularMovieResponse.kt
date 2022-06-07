package com.harunbekcan.paging3sampleproject.data.response

data class PopularMovieResponse(
    val page: Int,
    val results: List<PopularMovieResponseItem>,
    val total_pages: Int,
    val total_results: Int
)