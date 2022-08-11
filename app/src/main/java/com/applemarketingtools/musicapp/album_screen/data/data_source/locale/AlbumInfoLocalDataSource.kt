package com.applemarketingtools.musicapp.album_screen.data.data_source.locale

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel

interface AlbumInfoLocalDataSource {
    suspend fun getAlbumInfoData(): List<AlbumInfoDataModel>
    suspend fun insertAll(allAlbums: List<AlbumInfoDataModel>)

}