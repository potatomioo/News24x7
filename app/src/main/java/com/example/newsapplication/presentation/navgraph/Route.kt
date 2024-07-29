package com.example.newsapplication.presentation.navgraph

sealed class Route(
    val route : String
) {

    //creating obejcts in Route class of navGraph to navigate to specific position
    object OnBoardingScreen :  Route(route = "OnBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object BookMarkScreen : Route(route = "bookmarkScreen")
    object DetailScreen : Route(route = "detailScreen")

    //sub navigation
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")
    object NewsNavigatorScreen : Route(route = "newsNavigator")

}