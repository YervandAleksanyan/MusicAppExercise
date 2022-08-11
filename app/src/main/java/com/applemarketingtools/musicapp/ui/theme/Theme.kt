package com.applemarketingtools.musicapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun MusicAppExerciseTheme(
    style: MusicAppStyle = MusicAppStyle.Main,
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                MusicAppStyle.Main -> baseDarkPalette
            }
        }
        false -> {
            when (style) {
                MusicAppStyle.Main -> baseLightPalette
            }
        }
    }

    CompositionLocalProvider(
        LocalMusicAppColors provides colors,
        LocalMusicAppTypography provides typography,
        LocalMusicAppRoundedCornerShape provides shapes,
        content = content
    )
}