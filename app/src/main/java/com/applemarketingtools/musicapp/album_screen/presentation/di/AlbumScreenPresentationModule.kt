package com.applemarketingtools.musicapp.album_screen.presentation.di

import com.applemarketingtools.musicapp.album_screen.presentation.mapper.AlbumInfoDomainToUiMapper
import com.applemarketingtools.musicapp.album_screen.presentation.viewmodel.AlbumScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val albumInfoPresentationModule = module {
    factory { AlbumInfoDomainToUiMapper() }
    viewModel {
        AlbumScreenViewModel(getAlbumInfoUseCase = get(), albumInfoDomainToUiMapper = get())
    }
}
