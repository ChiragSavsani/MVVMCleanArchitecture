package com.campusknot.newsapiclient.data.repository.dataSource

import com.campusknot.newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse>

    suspend fun getSearchedNewsLines(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<APIResponse>

}