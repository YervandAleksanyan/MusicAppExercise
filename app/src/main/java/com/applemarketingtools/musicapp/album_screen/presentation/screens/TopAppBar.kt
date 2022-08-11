package com.applemarketingtools.musicapp.album_screen.presentation.screens

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable

@Composable
fun SetupMainToolBar(
    lazyListState: LazyGridState,
    content: @Composable () -> Unit


) {
    MotionAppBar(lazyScrollState = lazyListState, content = content)
}
