package com.codezila.newsapp.presentation.navgraph

sealed class Route (
    val route: String
){
    // main navigation - screens
    object  OnboardingScreen: Route(route = "onBoardingScreen")
    object  HomeScreen: Route(route = "homeScreen")
    object  SearchScreen: Route(route = "searchScreen")
    object BookmarkScreen: Route(route = "bookmarkScreen")
    object DetailsScreen: Route(route = "detailsScreen")

    //sub navigations
    object AppStartNav: Route(route = "appStartNav")
    object NewsNavigation: Route(route = "newsNavigation")
    object NewsNavigationScreen: Route(route = "newsNavigator")
}

