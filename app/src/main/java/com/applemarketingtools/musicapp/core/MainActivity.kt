package com.applemarketingtools.musicapp.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.applemarketingtools.musicapp.core.navigation.AppNavGraph
import com.applemarketingtools.musicapp.ui.theme.MusicAppExerciseTheme
import com.applemarketingtools.musicapp.ui.theme.MusicAppStyle
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val isDarkModeValue = isSystemInDarkTheme()
            val currentStyle by remember { mutableStateOf(MusicAppStyle.Main) }
            val isDarkMode by remember { mutableStateOf(isDarkModeValue) }
            val systemUiController = rememberSystemUiController()

            if (isDarkMode) {
                systemUiController.setSystemBarsColor(color = Color.Transparent)
            } else {
                systemUiController.setSystemBarsColor(color = Color.White)
            }

            MusicAppExerciseTheme(
                darkTheme = isDarkMode,
                style = currentStyle
            ) {
                CompositionLocalProvider {
                    val animatedNavController = rememberAnimatedNavController()
                    AppNavGraph(
                        navController = animatedNavController
                    )
                }
            }
        }
    }
}

