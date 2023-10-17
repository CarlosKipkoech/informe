package com.codezila.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    //Save the application entry when a user clicks on "Get Started Button"
    suspend fun  saveAppEntry()

    // read application entry
    fun readAppEntry(): Flow<Boolean> // ----> TRUE or FALSE
}