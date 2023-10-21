package com.codezila.newsapp.domain.repository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.codezila.newsapp.domain.model.Article

interface NewsRepository {

    fun  getNews(sources:List<String>) : Flow<PagingData<Article>>
    fun  searchNews(searchQuery:String,sources:List<String>) : Flow<PagingData<Article>>

}