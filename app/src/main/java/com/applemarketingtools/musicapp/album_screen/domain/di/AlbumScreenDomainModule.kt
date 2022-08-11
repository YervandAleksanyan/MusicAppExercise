package com.applemarketingtools.musicapp.album_screen.domain.di

import com.applemarketingtools.musicapp.album_screen.domain.usecase.impl.GetAlbumInfoUseCaseImpl
import com.applemarketingtools.musicapp.album_screen.data.repository_impl.AlbumInfoRepositoryImpl
import com.applemarketingtools.musicapp.core.di.DispatchersName
import com.applemarketingtools.musicapp.album_screen.domain.repository.AlbumInfoRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val albumInfoDomainModule = module {

    single<AlbumInfoRepository> {
        AlbumInfoRepositoryImpl(
            albumInfoLocalDataSource = get(),
            albumInfoRemoteDataSource = get(),
            albumInfoDataToDomainMapper = get(),
            albumInfoDomainToDataMapper = get()
        )
    }

    factory {
        GetAlbumInfoUseCaseImpl(
            coroutineDispatcher = get(qualifier = named(DispatchersName.IO)),
            musicAppRepo = get()
        )
    }
}
