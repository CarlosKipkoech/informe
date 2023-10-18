package com.codezila.newsapp.domain.usecase.AppEntry

import com.codezila.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry  (
    private val localUserManager: LocalUserManager
){
 operator fun invoke() :Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}