package com.codezila.newsapp.di

import android.app.Application
import com.codezila.newsapp.data.manager.LocalUserManagerImpl
import com.codezila.newsapp.domain.manager.LocalUserManager
import com.codezila.newsapp.domain.usecase.AppEntryUseCases
import com.codezila.newsapp.domain.usecase.ReadAppEntry
import com.codezila.newsapp.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

}