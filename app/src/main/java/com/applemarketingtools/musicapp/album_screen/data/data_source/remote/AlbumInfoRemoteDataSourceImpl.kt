package com.applemarketingtools.musicapp.album_screen.data.data_source.remote

import com.applemarketingtools.musicapp.album_screen.data.mapper.AlbumInfoResponseToDataModelMapper
import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.core.restservice.MusicAppRestServiceApi

class AlbumInfoRemoteDataSourceImpl(
    private val musicAppRestApi: MusicAppRestServiceApi,
    private val albumInfoResponseToDataModelMapper: AlbumInfoResponseToDataModelMapper
) : AlbumInfoRemoteDataSource {


    override suspend fun getAlbumInfoData(pageCount: Int): List<AlbumInfoDataModel> {

        val response = musicAppRestApi.getAlbumInfoData(page = pageCount)?.feed
        val albumInfoDataResponse = response?.results
        return albumInfoResponseToDataModelMapper.map(albumInfoDataResponse?.map { it.copy(copyright = response.copyright) }
            ?: emptyList())
    }
}
