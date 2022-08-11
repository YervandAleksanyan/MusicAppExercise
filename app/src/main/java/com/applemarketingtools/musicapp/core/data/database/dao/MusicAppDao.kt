package com.applemarketingtools.musicapp.core.data.database.dao

import com.applemarketingtools.musicapp.album_screen.data.models.entityes.AlbumInfoDataEntity


interface MusicAppDao {
    fun insertAllAlbumInfo(albumInfoListData: List<AlbumInfoDataEntity>)
    fun getAllAlbumInfo(): List<AlbumInfoDataEntity>
}