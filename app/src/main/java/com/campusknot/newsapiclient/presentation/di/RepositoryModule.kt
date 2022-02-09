package com.campusknot.newsapiclient.presentation.di

import com.campusknot.newsapiclient.data.repository.NewsRepositoryImpl
import com.campusknot.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.campusknot.newsapiclient.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import com.campusknot.newsapiclient.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}