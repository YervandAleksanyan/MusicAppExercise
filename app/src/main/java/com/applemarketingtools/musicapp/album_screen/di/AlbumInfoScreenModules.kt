package com.applemarketingtools.musicapp.album_screen.di

import com.applemarketingtools.musicapp.album_screen.data.di.albumInfoDataModule
import com.applemarketingtools.musicapp.album_screen.domain.di.albumInfoDomainModule
import com.applemarketingtools.musicapp.album_screen.presentation.di.albumInfoPresentationModule

val albumInfoScreenModules = albumInfoDataModule + albumInfoDomainModule +
        albumInfoPresentationModule