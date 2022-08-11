package com.applemarketingtools.musicapp.album_details_screen.presentation.model

import androidx.compose.runtime.Immutable


@Immutable
sealed class AlbumInfoDetailsSideEffect {
    data class OnVisitButtonClicked(
        val isClicked: Boolean,
        val artistUrl: String
    ) : AlbumInfoDetailsSideEffect()
}