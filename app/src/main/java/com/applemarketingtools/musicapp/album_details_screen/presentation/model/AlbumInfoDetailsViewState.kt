package com.applemarketingtools.musicapp.album_details_screen.presentation.model

import androidx.compose.runtime.Immutable
import com.applemarketingtools.musicapp.core.mvi.UiStatus

@Immutable
data class AlbumInfoDetailsViewState(
    val status: UiStatus,
    val data: AlbumInfoDetailsPresentationModel
) {
    companion object {
        fun initial() = AlbumInfoDetailsViewState(
            status = UiStatus.Loading,
            data = AlbumInfoDetailsPresentationModel.initial()
        )
    }
}