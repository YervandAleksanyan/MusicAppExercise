package com.applemarketingtools.musicapp.core.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.applemarketingtools.musicapp.R


@Composable
fun EmptyListScreen(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val isLottiePlaying = remember {
            mutableStateOf(true)
        }
        val animationSpeed by remember {
            mutableStateOf(1f)
        }
        val composition by rememberLottieComposition(
            LottieCompositionSpec
                .RawRes(R.raw.emty_list_anim)
        )
        val lottieAnimation by animateLottieCompositionAsState(
            // pass the composition created above
            composition,
            // Iterates Forever
            iterations = LottieConstants.IterateForever,
            // Lottie and pause/play
            isPlaying = isLottiePlaying.value,
            // Increasing the speed of change Lottie
            speed = animationSpeed,
            restartOnPlay = false

        )

        LottieAnimation(
            composition,
            lottieAnimation,
            modifier = Modifier
                .height(height = 300.dp)
        )
    }
}