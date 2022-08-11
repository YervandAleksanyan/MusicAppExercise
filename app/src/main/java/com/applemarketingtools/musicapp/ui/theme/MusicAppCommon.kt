package com.applemarketingtools.musicapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class MusicAppColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val primaryTextToolBar: Color,
    val secondaryTextToolBar: Color,
    val buttonPrimary: Color,
    val body2PrimaryText: Color,
    val body2SecondaryText: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class MusicAppTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

data class MusicAppRoundedCornerShape(
    val shapeLarge: RoundedCornerShape,
    val shapeMedium: RoundedCornerShape,
    val shapeSmall: RoundedCornerShape,
)

object MusicAppTheme {
    val colors: MusicAppColors
        @Composable
        get() = LocalMusicAppColors.current

    val typography: MusicAppTypography
        @Composable
        get() = LocalMusicAppTypography.current

    val roundedCornerShape: MusicAppRoundedCornerShape
        @Composable
        get() = LocalMusicAppRoundedCornerShape.current
}

enum class MusicAppStyle {
    Main
}


val LocalMusicAppColors = staticCompositionLocalOf<MusicAppColors> {
    error("No colors provided")
}
val LocalMusicAppTypography = staticCompositionLocalOf<MusicAppTypography> {
    error("No font provided")
}

val LocalMusicAppRoundedCornerShape = staticCompositionLocalOf<MusicAppRoundedCornerShape> {
    error("No shape provided")
}
