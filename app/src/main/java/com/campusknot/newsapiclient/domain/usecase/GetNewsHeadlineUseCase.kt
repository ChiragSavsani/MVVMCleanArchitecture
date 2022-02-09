package com.campusknot.newsapiclient.domain.usecase

import com.campusknot.newsapiclient.data.model.APIResponse
import com.campusknot.newsapiclient.data.util.Resource
import com.campusknot.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlineUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        //Get can also get data from repository and can modify and return the updated data here
        return newsRepository.getNewsHeadlines(country, page)
    }
}