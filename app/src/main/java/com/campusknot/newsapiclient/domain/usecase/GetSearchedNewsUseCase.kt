package com.campusknot.newsapiclient.domain.usecase

import com.campusknot.newsapiclient.data.model.APIResponse
import com.campusknot.newsapiclient.data.util.Resource
import com.campusknot.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}