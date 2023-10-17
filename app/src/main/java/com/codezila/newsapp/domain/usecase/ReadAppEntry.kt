package com.codezila.newsapp.domain.usecase

import com.codezila.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry  (
    private val localUserManager: LocalUserManager
){
    suspend operator fun invoke() :Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}