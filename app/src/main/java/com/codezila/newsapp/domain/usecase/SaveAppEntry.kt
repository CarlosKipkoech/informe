package com.codezila.newsapp.domain.usecase

import com.codezila.newsapp.domain.manager.LocalUserManager

class SaveAppEntry (
    private val localUserManager: LocalUserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}