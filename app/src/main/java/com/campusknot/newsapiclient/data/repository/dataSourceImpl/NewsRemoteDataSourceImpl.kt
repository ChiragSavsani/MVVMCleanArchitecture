package com.campusknot.newsapiclient.data.repository.dataSourceImpl

import com.campusknot.newsapiclient.data.api.NewsAPIService
import com.campusknot.newsapiclient.data.model.APIResponse
import com.campusknot.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
) : NewsRemoteDataSource {

    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadLines(country, page)
    }

    override suspend fun getSearchedNewsLines(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadLines(country, searchedQuery, page)
    }
}