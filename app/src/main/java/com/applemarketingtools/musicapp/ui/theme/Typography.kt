package com.applemarketingtools.musicapp.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.applemarketingtools.musicapp.R

val fontFamily = FontFamily(
    Font(R.font.sf_pro_text_bold, FontWeight.W700),
    Font(R.font.sf_pro_text_medium, FontWeight.W500),
    Font(R.font.sf_pro_text_regular, FontWeight.W400)


)
val typography = MusicAppTypography(
    titleLarge = TextStyle(
        fontSize = 34.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.W700
         ),
    titleMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.W500
    ),
    titleSmall = TextStyle(
        fontSize = 10.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.W400
    ),
    labelLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.W400
    ),
    labelMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.W600
    ),
    labelSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.W500
    )
)