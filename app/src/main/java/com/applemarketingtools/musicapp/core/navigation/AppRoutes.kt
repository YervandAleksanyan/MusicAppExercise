package com.applemarketingtools.musicapp.core.navigation

sealed class AppRoutes(val route: String) {
    object SplashScreen : AppRoutes(route = "Splash_Screen")
    object AlbumInfoScreen : AppRoutes(route = "Album_Info_Screen")
    object AlbumInfoDetailsScreen : AppRoutes(route = "Album_Info_Details_Screen")
}