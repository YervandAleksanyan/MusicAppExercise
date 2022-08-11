package com.applemarketingtools.musicapp.core.di

import com.applemarketingtools.musicapp.album_screen.data.models.entityes.AlbumInfoDataEntity
import com.applemarketingtools.musicapp.core.APP_DATABASE_NAME
import com.applemarketingtools.musicapp.core.data.database.dao.MusicAppDao
import com.applemarketingtools.musicapp.core.data.database.dao.MusicAppDaoImpl
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.dsl.module


val appDBModule = module {

    single<MusicAppDao> { MusicAppDaoImpl(realmAppDB = get()) }

    single { provideMusicAppDb() }

}

private fun provideMusicAppDb(): Realm {
    val config = RealmConfiguration.Builder(
        schema = setOf(AlbumInfoDataEntity::class)
    )
        .name(APP_DATABASE_NAME)
        .schemaVersion(schemaVersion = 1)
        .build()
    return Realm.open(configuration = config)
}

