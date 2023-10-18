package com.codezila.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codezila.newsapp.domain.usecase.AppEntry.AppEntryUseCases
import com.codezila.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
):ViewModel() {

    var splashCondition by mutableStateOf(true)
        private  set

    var startDestination by mutableStateOf(Route.AppStartNav.route)
        private  set


    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->

            if (shouldStartFromHomeScreen){
                startDestination = Route.NewsNavigation.route
        }else{
                startDestination = Route.AppStartNav.route
        }
        delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }




}