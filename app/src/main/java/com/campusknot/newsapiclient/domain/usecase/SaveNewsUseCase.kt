package com.campusknot.newsapiclient.domain.usecase

import com.campusknot.newsapiclient.data.model.Article
import com.campusknot.newsapiclient.data.util.Resource
import com.campusknot.newsapiclient.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}