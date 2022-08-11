package com.applemarketingtools.musicapp.album_screen.data.data_source.remote

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel

interface AlbumInfoRemoteDataSource {

    suspend fun getAlbumInfoData(pageCount:Int): List<AlbumInfoDataModel>
}