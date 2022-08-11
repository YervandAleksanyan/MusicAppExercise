package com.applemarketingtools.musicapp.album_screen.presentation.models

import androidx.compose.runtime.Immutable
import com.applemarketingtools.musicapp.core.mvi.UiStatus

@Immutable
data class AlbumInfoScreenViewState(
    val status: UiStatus,
    val data: List<AlbumInfoPresentationModel>

) {
    companion object {
        fun initial() = AlbumInfoScreenViewState(
            status = UiStatus.Loading,
            data = emptyList()
        )
    }
}
