package com.codezila.newsapp.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codezila.newsapp.domain.usecase.getNews.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    val news = newsUseCases.getNews(
        sources = listOf("bbc-news","abc-news","al-jazeera-english")
    ).cachedIn(viewModelScope)
}