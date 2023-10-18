package com.codezila.newsapp.data.remote

import com.codezila.newsapp.data.remote.dto.NewsResponse
import com.codezila.newsapp.util.Constants.API_KEY
import retrofit2.http.Query
import retrofit2.http.GET

interface NewsApi {
    @GET("everything")
    suspend fun  getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}