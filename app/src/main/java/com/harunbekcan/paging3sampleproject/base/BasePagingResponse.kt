package com.harunbekcan.paging3sampleproject.base

data class BasePagingResponse<T>(
    val result : List<T> = arrayListOf()
)