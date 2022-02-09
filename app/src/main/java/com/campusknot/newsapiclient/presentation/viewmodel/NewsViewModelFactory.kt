package com.campusknot.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.campusknot.newsapiclient.domain.usecase.GetNewsHeadlineUseCase
import com.campusknot.newsapiclient.domain.usecase.GetSearchedNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlineUseCase: GetNewsHeadlineUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlineUseCase,
            getSearchedNewsUseCase
        ) as T
    }
}