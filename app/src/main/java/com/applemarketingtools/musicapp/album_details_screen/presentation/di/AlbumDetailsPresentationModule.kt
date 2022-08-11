package com.applemarketingtools.musicapp.album_details_screen.presentation.di

import com.applemarketingtools.musicapp.album_details_screen.presentation.mappers.AlbumInfoUiToAlbumInfoDetailsUiMapper
import com.applemarketingtools.musicapp.album_details_screen.presentation.utils.StringFormatter
import com.applemarketingtools.musicapp.album_details_screen.presentation.viewmodel.AlbumInfoDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val albumDetailsScreenPresentationModule = module {

    factory { StringFormatter(context = get()) }
    factory { AlbumInfoUiToAlbumInfoDetailsUiMapper(stringFormatter = get()) }

    viewModel {
        AlbumInfoDetailsViewModel(uiMapper = get())
    }
}