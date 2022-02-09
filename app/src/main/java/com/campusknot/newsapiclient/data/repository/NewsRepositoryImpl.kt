package com.campusknot.newsapiclient.data.repository

import com.campusknot.newsapiclient.data.model.APIResponse
import com.campusknot.newsapiclient.data.model.Article
import com.campusknot.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.campusknot.newsapiclient.data.util.Resource
import com.campusknot.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource((newsRemoteDataSource.getTopHeadLines(country, page)))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            (newsRemoteDataSource.getSearchedNewsLines(
                country,
                searchQuery,
                page
            ))
        )
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}