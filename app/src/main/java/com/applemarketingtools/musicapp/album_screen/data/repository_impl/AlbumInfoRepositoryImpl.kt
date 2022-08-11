package com.applemarketingtools.musicapp.album_screen.data.repository_impl

import com.applemarketingtools.musicapp.album_screen.data.data_source.locale.AlbumInfoLocalDataSource
import com.applemarketingtools.musicapp.album_screen.data.data_source.remote.AlbumInfoRemoteDataSource
import com.applemarketingtools.musicapp.album_screen.data.mapper.AlbumInfoDataToDomainModelMapper
import com.applemarketingtools.musicapp.album_screen.data.mapper.AlbumInfoDomainToDataModelMapper
import com.applemarketingtools.musicapp.album_screen.domain.models.AlbumInfoDomainModel
import com.applemarketingtools.musicapp.core.domain.repository.MultiSourceRepository
import com.applemarketingtools.musicapp.album_screen.domain.repository.AlbumInfoRepository
import com.applemarketingtools.musicapp.core.domain.repository.cacheElseNetwork
import com.applemarketingtools.musicapp.core.model.Result
import kotlinx.coroutines.flow.Flow

class AlbumInfoRepositoryImpl(
    private val albumInfoLocalDataSource: AlbumInfoLocalDataSource,
    private val albumInfoRemoteDataSource: AlbumInfoRemoteDataSource,
    private val albumInfoDataToDomainMapper: AlbumInfoDataToDomainModelMapper,
    private val albumInfoDomainToDataMapper: AlbumInfoDomainToDataModelMapper,


    ) : AlbumInfoRepository, MultiSourceRepository {


    override fun getAlbumInfoData(count: Int): Flow<Result<List<AlbumInfoDomainModel>>> =

        cacheElseNetwork(
            cacheCall = {
                albumInfoLocalDataSource.getAlbumInfoData().map { albumInfoDataModel ->
                    albumInfoDataToDomainMapper.map(albumInfoDataModel)
                }
            },
            networkCall = {
                albumInfoRemoteDataSource.getAlbumInfoData(pageCount = count)
                    .map { albumInfoDataModel ->
                        albumInfoDataToDomainMapper.map(albumInfoDataModel)
                    }
            },
            updateCache = { listAlbumInfoDomain ->
                val result = listAlbumInfoDomain.map { albumInfoDomainToDataMapper.map(it) }
                albumInfoLocalDataSource.insertAll(result)
            }
        )
}