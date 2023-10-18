package com.codezila.newsapp.data.remote.dto

import com.codezila.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)