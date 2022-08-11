package com.applemarketingtools.musicapp.album_screen.data.data_source.locale

import com.applemarketingtools.musicapp.album_screen.data.mapper.AlbumInfoDBToDataModelMapper
import com.applemarketingtools.musicapp.album_screen.data.mapper.AlbumInfoDataToDBModelMapper
import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.core.data.database.dao.MusicAppDao

class AlbumInfoLocalDataSourceImpl(
    private val musicAppDao: MusicAppDao,
    private val albumInfoDBToDataMapper: AlbumInfoDBToDataModelMapper,
    private val albumInfoDataToDBMapper: AlbumInfoDataToDBModelMapper,

    ) :
    AlbumInfoLocalDataSource {
    override suspend fun getAlbumInfoData(): List<AlbumInfoDataModel> {
        return albumInfoDBToDataMapper.map(musicAppDao.getAllAlbumInfo())
    }

    override suspend fun insertAll(allAlbums: List<AlbumInfoDataModel>) {
        val result = allAlbums.map { albumInfoDataToDBMapper.map(it) }
        musicAppDao.insertAllAlbumInfo(albumInfoListData = result)
    }
}