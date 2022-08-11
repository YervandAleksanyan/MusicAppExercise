package com.applemarketingtools.musicapp.album_screen.data.models.network

import com.google.gson.annotations.SerializedName


data class AlbumInfoResponse(
    val feed: FeedDataResponse?
)

data class LinkDataResponse(
    val self: String?
)

data class FeedDataResponse(
    val author: AlbumInfoResponse?,
    val copyright: String?,
    val country: String?,
    val icon: String?,
    val id: String?,
    val links: List<LinkDataResponse>?,
    val results: List<AlbumInfoDataResponse>?,
    val title: String?,
    val updated: String?
)

data class GenreDataResponse(
    val genreId: String?,
    val name: String?,
    val url: String?
)

data class AlbumInfoDataResponse(
    @SerializedName("artistId") val artistId: String?,
    @SerializedName("artistName") val artistName: String?,
    @SerializedName("artistUrl") val artistUrl: String?,
    @SerializedName("artworkUrl100") val imageUrl: String?,
    @SerializedName("contentAdvisoryRating") val contentAdvisoryRating: String?,
    @SerializedName("genres") val genres: List<GenreDataResponse>?,
    @SerializedName("id") val id: String?,
    @SerializedName("kind") val kind: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("releaseDate") val releaseDate: String?,
    @SerializedName("url") val url: String?,
    var copyright: String? = null,

    ) {
    companion object {
        fun initial(): AlbumInfoDataResponse {
            return AlbumInfoDataResponse(
                artistName = null,
                artistUrl = null,
                imageUrl = null,
                contentAdvisoryRating = null,
                genres = null,
                id = null,
                kind = null,
                name = null,
                releaseDate = null,
                url = null,
                artistId = null
            )
        }
    }
}

data class AuthorDataResponse(
    @SerializedName("") val name: String?,
    @SerializedName("") val url: String?
)