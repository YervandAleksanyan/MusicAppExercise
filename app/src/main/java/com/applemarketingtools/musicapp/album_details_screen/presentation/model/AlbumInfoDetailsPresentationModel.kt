package com.applemarketingtools.musicapp.album_details_screen.presentation.model

import androidx.compose.runtime.Immutable


@Immutable
data class AlbumInfoDetailsPresentationModel(
    val artistId: String,
    val artistName: String,
    val artistUrl: String,
    val imageUrl: String,
    val contentAdvisoryRating: String,
    val id: String,
    val kind: String,
    val name: String,
    val releaseDate: String,
    val url: String,
    val copyright: String

) {
    companion object {
        fun initial() = AlbumInfoDetailsPresentationModel(
            artistId = "",
            artistName = "",
            artistUrl = "",
            imageUrl = "",
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
