package com.applemarketingtools.musicapp.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.applemarketingtools.musicapp.album_details_screen.presentation.screens.AlbumInfoDetailsScreen
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoPresentationModel
import com.applemarketingtools.musicapp.album_screen.presentation.screens.AlbumInfoScreen
import com.applemarketingtools.musicapp.core.extensions.fromJson
import com.applemarketingtools.musicapp.app_splash_screen.AnimatedSplashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = AppRoutes.SplashScreen.route
    ) {

        composable(route = AppRoutes.SplashScreen.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = AppRoutes.AlbumInfoScreen.route) {
            AlbumInfoScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navController = navController
            )
        }

        composable(
            route = "${AppRoutes.AlbumInfoDetailsScreen.route}/{data}",
            arguments = listOf(
                navArgument("data") {
                    type = NavType.StringType
                }),
            enterTransition = {
                slideInHorizontally(animationSpec = tween(500)) { 1100 }
            },
            popEnterTransition = {
                slideInHorizontally(animationSpec = tween(500)) { -1100 }
            },
            exitTransition = {
                slideOutHorizontally(animationSpec = tween(500)) { -1100 }
            },
            popExitTransition = {
                slideOutHorizontally(animationSpec = tween(500)) { 1100 }
            },
        ) {
            val data = it.arguments?.getString("data")
            data?.let {
                if (data.isNotEmpty()){
                    AlbumInfoDetailsScreen(
                        modifier = Modifier.fillMaxSize(),
                        albumInfoData = data.fromJson(AlbumInfoPresentationModel::class.java),
                        navController = navController
                    )
                }
            }
        }
    }
}