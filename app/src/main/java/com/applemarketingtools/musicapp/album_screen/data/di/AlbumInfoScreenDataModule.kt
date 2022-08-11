package com.applemarketingtools.musicapp.album_screen.data.di

import com.applemarketingtools.musicapp.album_screen.data.data_source.locale.AlbumInfoLocalDataSource
import com.applemarketingtools.musicapp.album_screen.data.data_source.locale.AlbumInfoLocalDataSourceImpl
import com.applemarketingtools.musicapp.album_screen.data.data_source.remote.AlbumInfoRemoteDataSource
import com.applemarketingtools.musicapp.album_screen.data.data_source.remote.AlbumInfoRemoteDataSourceImpl
import com.applemarketingtools.musicapp.album_screen.data.mapper.*
import org.koin.dsl.module

val albumInfoDataModule = module {

    factory { AlbumInfoResponseToDataModelMapper() }
    factory { AlbumInfoDataToDBModelMapper() }
    factory { AlbumInfoDBToDataModelMapper() }
    factory { AlbumInfoDataToDomainModelMapper() }
    factory { AlbumInfoDomainToDataModelMapper() }


    factory<AlbumInfoRemoteDataSource> {
        AlbumInfoRemoteDataSourceImpl(
            musicAppRestApi = get(),
            albumInfoResponseToDataModelMapper = get()
        )
    }
    factory<AlbumInfoLocalDataSource> {
        AlbumInfoLocalDataSourceImpl(
            musicAppDao = get(),
            albumInfoDataToDBMapper = get(),
            albumInfoDBToDataMapper = get()
        )
    }
}