package com.codezila.newsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.codezila.newsapp.presentation.homeScreen.HomeScreen
import com.codezila.newsapp.presentation.homeScreen.HomeViewModel
import com.codezila.newsapp.presentation.onboarding.OnBoardingScreen
import com.codezila.newsapp.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph (
    startDestination: String
){

     val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination=startDestination ){
        navigation(
            route = Route.AppStartNav.route,
            startDestination = Route.OnboardingScreen.route
        ){
            composable(
                route= Route.OnboardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event =  viewModel::onEvent

                    // same as this:
                    //event = {
                    //viewModel.onEvent(it)
                    // }
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ){
            composable(
                route= Route.NewsNavigationScreen.route
            ){
              val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigate ={} )
            }
        }
    }
}