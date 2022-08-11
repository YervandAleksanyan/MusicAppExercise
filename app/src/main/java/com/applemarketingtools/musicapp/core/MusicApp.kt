package com.applemarketingtools.musicapp.core

import android.app.Application
import com.applemarketingtools.musicapp.album_details_screen.di.albumInfoDetailsScreenModules
import com.applemarketingtools.musicapp.album_screen.di.albumInfoScreenModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MusicApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MusicApp)
            modules(coreModules + albumInfoScreenModules + albumInfoDetailsScreenModules)
        }
    }
}