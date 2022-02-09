package com.campusknot.newsapiclient.presentation.di

import android.app.Application
import com.campusknot.newsapiclient.domain.usecase.GetNewsHeadlineUseCase
import com.campusknot.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.campusknot.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlineUseCase: GetNewsHeadlineUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlineUseCase,
            getSearchedNewsUseCase
        )
    }

}