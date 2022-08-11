package com.applemarketingtools.musicapp.core.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.applemarketingtools.musicapp.ui.theme.MusicAppTheme

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(
                    Alignment.Center
                ),
            color = MusicAppTheme.colors.buttonPrimary
        )
    }
}

@Preview
@Composable
fun LoadingIndicator_Preview() {
    LoadingIndicator(modifier = Modifier.fillMaxSize())
}
