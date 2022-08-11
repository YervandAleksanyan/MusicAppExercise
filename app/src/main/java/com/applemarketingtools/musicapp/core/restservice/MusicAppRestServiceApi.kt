package com.applemarketingtools.musicapp.core.restservice

import com.applemarketingtools.musicapp.album_screen.data.models.network.AlbumInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MusicAppRestServiceApi {

    @GET("us/music/most-played/{page}/albums.json")
    suspend fun getAlbumInfoData(
        @Path("page") page: Int
    ): AlbumInfoResponse?
}