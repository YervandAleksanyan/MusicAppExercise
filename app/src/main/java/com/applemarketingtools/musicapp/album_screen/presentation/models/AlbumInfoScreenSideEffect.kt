package com.applemarketingtools.musicapp.album_screen.presentation.models

import androidx.compose.runtime.Immutable


@Immutable
sealed class AlbumInfoScreenSideEffect {

    data class NavigateToAlbumInfoDetailsScreen(val isItemClicked: Boolean,val data:String) : AlbumInfoScreenSideEffect()
}