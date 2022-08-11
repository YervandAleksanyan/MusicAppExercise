package com.applemarketingtools.musicapp.album_screen.presentation.models

import androidx.compose.runtime.Immutable


@Immutable
data class AlbumInfoPresentationModel(
    val artistId: String,
    val artistName: String,
    val artistUrl: String,
    val artworkUrl100: String,
    val contentAdvisoryRating: String,
    val id: String,
    val kind: String,
    val name: String,
    val releaseDate: String,
    val url: String,
    val copyright: String

) {
    companion object {
        fun initial() = AlbumInfoPresentationModel(
            artistId = "",
            artistName = "",
            artistUrl = "",
            artworkUrl100 = "",
            id = "",
            kind = "",
            name = "",
            releaseDate = "",
            url = "",
            contentAdvisoryRating = "",
            copyright = ""
        )
    }
}


