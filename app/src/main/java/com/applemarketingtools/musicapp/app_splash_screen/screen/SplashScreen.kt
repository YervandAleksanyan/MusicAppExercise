package com.applemarketingtools.musicapp.app_splash_screen.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import com.applemarketingtools.musicapp.R
import com.applemarketingtools.musicapp.app_splash_screen.DEFAULT_SPLASH_SCREEN_ALPHA
import com.applemarketingtools.musicapp.ui.theme.MusicAppExerciseTheme
import com.applemarketingtools.musicapp.ui.theme.MusicAppTheme

@Composable
fun SplashScreen(alpha: Float) {

    // recourse
    val animIconSize = dimensionResource(id = R.dimen.splash_icon_size)

    val backgroundSplashScreen = MusicAppTheme.colors.primaryBackground
    val isLottiePlaying by remember {
        mutableStateOf(true)
    }
    val animationSpeed by remember {
        mutableStateOf(1f)
    }
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.splash_anim)
    )
    val lottieAnimation by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isLottiePlaying,
        speed = animationSpeed,
        restartOnPlay = false

    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundSplashScreen)
            .alpha(alpha = alpha)

    ) {
        LottieAnimation(
            composition,
            lottieAnimation,
            modifier = Modifier.size(animIconSize)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview() {
    MusicAppExerciseTheme(darkTheme = false) {
        SplashScreen(
            alpha = DEFAULT_SPLASH_SCREEN_ALPHA,
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SplashScreenDarkPreview() {
    MusicAppExerciseTheme(darkTheme = true) {
        SplashScreen(
            alpha = DEFAULT_SPLASH_SCREEN_ALPHA,
        )
    }
}
