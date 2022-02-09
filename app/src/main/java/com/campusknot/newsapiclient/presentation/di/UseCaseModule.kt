package com.campusknot.newsapiclient.presentation.di

import com.campusknot.newsapiclient.domain.repository.NewsRepository
import com.campusknot.newsapiclient.domain.usecase.GetNewsHeadlineUseCase
import com.campusknot.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadLinesUseCase(newsRepository: NewsRepository): GetNewsHeadlineUseCase {
        return GetNewsHeadlineUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsUseCase(newsRepository: NewsRepository): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }
}