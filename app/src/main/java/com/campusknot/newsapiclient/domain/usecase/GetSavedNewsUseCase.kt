package com.campusknot.newsapiclient.domain.usecase

import com.campusknot.newsapiclient.data.model.Article
import com.campusknot.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}