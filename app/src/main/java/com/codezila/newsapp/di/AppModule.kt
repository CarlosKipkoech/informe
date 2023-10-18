package com.codezila.newsapp.di

import android.app.Application
import com.codezila.newsapp.data.manager.LocalUserManagerImpl
import com.codezila.newsapp.data.remote.NewsApi
import com.codezila.newsapp.data.repository.NewsRepositoryImpl
import com.codezila.newsapp.domain.manager.LocalUserManager
import com.codezila.newsapp.domain.repository.NewsRepository
import com.codezila.newsapp.domain.usecase.appEntry.AppEntryUseCases
import com.codezila.newsapp.domain.usecase.appEntry.ReadAppEntry
import com.codezila.newsapp.domain.usecase.appEntry.SaveAppEntry
import com.codezila.newsapp.domain.usecase.getNews.GetNews
import com.codezila.newsapp.domain.usecase.getNews.NewsUseCases
import com.codezila.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ):LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun providesNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}